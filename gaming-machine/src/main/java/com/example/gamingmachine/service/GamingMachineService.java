package com.example.gamingmachine.service;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gamingmachine.entity.GamingMachine;
import com.example.gamingmachine.repository.GamingMachineRepository;

@Service
public class GamingMachineService {
    // Implement methods for handling coin entry, game start, and refund.
	 @Autowired
	    private GamingMachineRepository gamingMachineRepository;

	    public GamingMachine enterCoins(List<CoinRequest> coinRequests, double hours) {
	        // Validate the coin denominations and calculate the total amount
	        double totalAmount = 0;
	        for (CoinRequest coinRequest : coinRequests) {
	            int denomination = coinRequest.getDenomination();
	            int quantity = coinRequest.getQuantity();
	            if (denomination == 1 || denomination == 2 || denomination == 5 || denomination == 10) {
	                totalAmount += denomination * quantity;
	            } else {
	                throw new IllegalArgumentException("Invalid coin denomination: " + denomination);
	            }
	        }

	        // Check for the minimum gaming hours
	        if (hours < 1) {
	            throw new IllegalArgumentException("Minimum gaming hours allowed is 1.");
	        }

	        // Calculate the valid till time
	        LocalDateTime currentTime = LocalDateTime.now();
	        LocalDateTime validTillTime = currentTime.plusDays((long) hours);

	        // Create a GamingMachine entity to store in the database
	        GamingMachine gamingMachine = new GamingMachine();
	        gamingMachine.setTotalAmount(totalAmount);
	        gamingMachine.LocalDate(currentTime);
	        gamingMachine.setValidTillTime(validTillTime);

	        // Save the entity in the database
	        gamingMachineRepository.save(gamingMachine);

	        // Return a response with the welcome message and remaining change
	        double remainingChange = totalAmount - (hours * 10); // 10 Rs per hour
	        return gamingMachine;
	    }

	    public double cancelGame(Long gameId) {
	        // Find the GamingMachine entity by gameId
	        Optional<GamingMachine> optionalMachine = gamingMachineRepository.findById(gameId);
	        if (!optionalMachine.isPresent()) {
	            throw new IllegalArgumentException("Invalid Game ID: " + gameId);
	        }

	        GamingMachine gamingMachine = optionalMachine.get();
	        LocalDateTime currentTime = LocalDateTime.now();

	        // Calculate the refund amount
	        double refundAmount = gamingMachine.getTotalAmount() - (Duration.between(gamingMachine.getStartTime(), currentTime).toHours() * 10);

	        // Update the revenue in the database
	        // You can add a revenue field in the GamingMachine entity and update it here

	        // Delete the GamingMachine entity from the database
	        gamingMachineRepository.delete(gamingMachine);

	        return refundAmount;
	    }
	}
