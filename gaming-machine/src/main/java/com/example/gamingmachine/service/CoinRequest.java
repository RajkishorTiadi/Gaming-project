package com.example.gamingmachine.service;

public class CoinRequest {
    private int denomination;
    private int quantity;

    // Constructors, getters, and setters for the fields.

    public CoinRequest() {
    }

    public CoinRequest(int denomination, int quantity) {
        this.denomination = denomination;
        this.quantity = quantity;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
