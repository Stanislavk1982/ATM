package com.java.stanislav_k.atminoffice;

import com.java.stanislav_k.exeption.ErrorSecurity;

import java.util.Calendar;

public class PrivatbankSecurity implements Security {
    private Bank bank;

    public PrivatbankSecurity(Bank bank) {
        this.bank = bank;
    }


    public void pinCodForCard(int pinCode) throws ErrorSecurity {
        if (pinCode != 54321) {
            throw new ErrorSecurity("Pin code is false");
        }
    }

    public boolean isExpire() {
        Calendar expireDate = Calendar.getInstance();
        Calendar dateNow = Calendar.getInstance();
        expireDate.set(2018, 11, 30);
        if (expireDate.compareTo(dateNow) > 0) {
            return true;
        }
        return false;
    }

    public double moneyAccount(Card card, int pinCode) throws ErrorSecurity {
        pinCodForCard(pinCode);
        return bank.checkSum(card);
    }

    public boolean moneyTransfer(Card card, int pincode, int sum) throws ErrorSecurity {
        pinCodForCard(pincode);
        return bank.getMoneyFromAccount(card, sum);
    }
}
