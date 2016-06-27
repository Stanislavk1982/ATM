package com.java.Stanislav.ATM;

public class MainATM {
    public static void main(String[] args) {
        Card card = new Card("5610000000000001", "MC");
        Bank bank = new Bank();
        SecurityInterface security = new Security(bank);

        ATMInterface atm = ATM.newInstance(1234567, security);
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
