package com.java.stanislav_k.atminoffice;

public class Card {
    private String idCard;
    private String paymentSystem;


    public Card(String idCard, String paymentSystem) {
        this.idCard = idCard;
        this.paymentSystem = paymentSystem;
    }

    public boolean checkCorrectNumber(String idCard) {
        int tempSum = 0;
        char number;
        for (int i = 1; i < idCard.length() + 1; i++) {
            number = idCard.charAt(i - 1);
            if (i % 2 == 1) {
                tempSum += Integer.parseInt(String.valueOf(number));
            } else {
                tempSum += Integer.parseInt(String.valueOf(number)) * 2;
            }
        }
        if (tempSum % 10 == 0) {
            return true;
        }
        return false;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPaymentSystem() {

        System.out.println(paymentSystem);
        return paymentSystem;
    }

    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }
}
