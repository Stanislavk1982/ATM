package com.java.stanislav_k.atminoffice;

import com.java.stanislav_k.exeption.ErrorSecurity;

public interface Security {

    void pinCodForCard(int pinCode) throws ErrorSecurity;

    boolean isExpire();

    double moneyAccount(Card card, int pinCode) throws ErrorSecurity;

    boolean moneyTransfer(Card card, int pincode, int sum) throws ErrorSecurity;
}
