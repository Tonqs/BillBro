package com.example.billbro.Party;

public class evenSplitCalculate implements Calculate {

    @Override
    public double calculate(double amount,  int amountFriend) {
        return amount/amountFriend;
    }
}
