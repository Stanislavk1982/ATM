package com.java.Stanislav.ATM;

public interface SecurityInterface {

    void pinCodForCard(int pinCode) throws ErrorSecurity;

    boolean isExpire();

    double moneyAccount(Card card, int pinCode) throws ErrorSecurity;

    boolean moneyTransfer(Card card, int pincode, int sum) throws ErrorSecurity;
}
