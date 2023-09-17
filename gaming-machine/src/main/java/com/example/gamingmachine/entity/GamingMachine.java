package com.example.gamingmachine.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GamingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int coinDenomination;
    private int numberOfCoins;
    private double numberOfHours;
    private double totalAmount;
    private LocalDate startTime;
    private LocalDate validTill;
    private double refundAmount;
    private boolean active;
    //    // Constructors, getters, and setters
	public GamingMachine(Long id, int coinDenomination, int numberOfCoins, double numberOfHours, LocalDate startTime,
			LocalDate validTill, double refundAmount, boolean active) {
		super();
		this.id = id;
		this.coinDenomination = coinDenomination;
		this.numberOfCoins = numberOfCoins;
		this.numberOfHours = numberOfHours;
		this.startTime = startTime;
		this.validTill = validTill;
		this.refundAmount = refundAmount;
		this.active = active;
	}
	public GamingMachine() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCoinDenomination() {
		return coinDenomination;
	}
	public void setCoinDenomination(int coinDenomination) {
		this.coinDenomination = coinDenomination;
	}
	public int getNumberOfCoins() {
		return numberOfCoins;
	}
	public void setNumberOfCoins(int numberOfCoins) {
		this.numberOfCoins = numberOfCoins;
	}
	public double getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	public LocalDate getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDate localDateTime) {
		this.startTime = localDateTime;
	}
	public LocalDate getValidTill() {
		return validTill;
	}
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}
	public double getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setTotalAmount(double totalAmount) {
		// TODO Auto-generated method stub
        this.totalAmount = totalAmount;

	}

}
