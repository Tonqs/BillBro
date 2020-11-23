package com.example.billbro.Party;

import java.util.ArrayList;

public class Party {
    private int p_id;
    private String name;
    private String restaurant;
    private String date;
    private double amount;
    private int amountFriend;
    private ArrayList<Companion> companions;

    public Party(int id, String name, String restaurant, String date, double amount, int amountFriend) {
        this.p_id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.date = date;
        this.amount = amount;
        this.amountFriend = amountFriend;
    }

    public void setCompanions(ArrayList<Companion> companions) {
        this.companions = companions;
    }

    public int getId() {
        return p_id;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getAmountFriend() {
        return amountFriend;
    }

    public ArrayList<Companion> getCompanions() {
        return companions;
    }
}
