package com.example.gamingmachine.repository;
import com.example.gamingmachine.entity.GamingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamingMachineRepository extends JpaRepository<GamingMachine, Long> {
    // Define custom query methods if needed.
}