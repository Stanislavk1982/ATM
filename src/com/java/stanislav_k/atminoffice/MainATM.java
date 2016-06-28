package com.java.stanislav_k.atminoffice;

import com.java.stanislav_k.exeption.ErrorSecurity;
import com.java.stanislav_k.exeption.IncorrectCard;

public class MainATM {
    public static void main(String[] args) {
        Card card = new Card("5610000000000001", "MC");
        Bank bank = new PrivatBank();
        Security security = new PrivatbankSecurity(bank);

        ATM atm = ATMPrivatBank.newInstance(1234567, security);
        atm.setCard(card);
        System.out.println("Enter Card");
        try {
            atm.insertionOfTheCard(card);
        } catch (IncorrectCard incorrectCard) {
            incorrectCard.printStackTrace();
        }
        System.out.println("Enter Pin Code");
        try {
            atm.enterPicCode(54321);
        } catch (ErrorSecurity errorSecurity) {
            errorSecurity.printStackTrace();
        }

    }
}
