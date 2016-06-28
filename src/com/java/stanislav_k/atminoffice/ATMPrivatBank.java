package com.java.stanislav_k.atminoffice;

import com.java.stanislav_k.exeption.ErrorSecurity;
import com.java.stanislav_k.exeption.IncorrectCard;
import com.java.stanislav_k.exeption.NotEnougtMoneyInATM;

import java.util.Calendar;
import java.util.Scanner;

public class ATMPrivatBank implements ATM {
    private Card card;
    Security security;
    private boolean cardCorrect = false;
    private boolean authentication = false;
    private int pinCode = 54321;
    private int sumInATM;
    private static ATMPrivatBank atm = null;

    private ATMPrivatBank(int sumInATM, Security security) {
        this.sumInATM = sumInATM;
        this.security = security;


    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void insertionOfTheCard(Card card) throws IncorrectCard {
        boolean sensorOfTheReader = true;
        if (!sensorOfTheReader) {
            throw new IncorrectCard("You inserted not banking card");
        }
        if (isTruePaySystem(card)) {
            throw new IncorrectCard("This Payment system isn't supported");
        }
        if (!card.checkCorrectNumber(card.getIdCard())) {
            throw new IncorrectCard("You Card is fake");
        }
        cardCorrect = true;
    }

    private boolean isTruePaySystem(Card card) {
        return !card.getPaymentSystem().equals("MC") && !card.getPaymentSystem().equals("Visa");
    }

    public void enterPicCode(int pinCode) throws ErrorSecurity {
        if (pinCode < 999 || pinCode > 9999999) {
            throw new ErrorSecurity("You enter incorrect PinCode");
        }
        //if (security.pinCodForCard(pinCode)) {
        //    throw new ErrorSecurity("You PinCode isn't true");
        //}
        if (!security.isExpire()) {
            throw new ErrorSecurity("You card is expire");
        }
        authentication = true;
        windowChoise();
        this.pinCode = pinCode;

    }

    public void windowChoise() {
        System.out.println("Authefiation OK");
        System.out.println("Select operation: Check account, Money transfer");
        Scanner scanner = new Scanner(System.in);
        String choise = "1";
        //scanner.next();
        switch (choise) {
            case "1":
                windowAccount();
                break;
            case "2":
                try {
                    windowTransfer();
                } catch (NotEnougtMoneyInATM notEnougtMoneyInATM) {
                    notEnougtMoneyInATM.printStackTrace();
                } catch (ErrorSecurity errorSecurity) {
                    errorSecurity.printStackTrace();
                }

                break;

        }
    }

    public void windowAccount() {
        try {
            System.out.println("Sum on Account is : " + security.moneyAccount(card, pinCode));
        } catch (ErrorSecurity errorSecurity) {
            errorSecurity.printStackTrace();
        }

    }

    public void windowTransfer() throws NotEnougtMoneyInATM, ErrorSecurity {
        System.out.println("Enter sum which you want to get");
        Scanner scanner = new Scanner(System.in);
        String enterSum = scanner.next();
        int sum = Integer.getInteger(enterSum);
        security.moneyTransfer(card, pinCode, sum);
        cashAdvance(sum);
        printBill(sum);

    }

    public void windowMobile() {
        System.out.println();
    }

    private void cashAdvance(int sum) throws NotEnougtMoneyInATM {
        if (sum < sumInATM) {
            System.out.println("Take you money");
            sumInATM -= sum;
        } else
            throw new NotEnougtMoneyInATM("Not enought money in ATM");

    }

    private void printBill(int sum) {
        Calendar now = Calendar.getInstance();
        System.out.println("Bill. You removed: " + sum + " Uah. Date is:  " + now);
    }

    public static ATMPrivatBank newInstance(int sumInATM, Security security) {
        if (atm == null) {
            atm = new ATMPrivatBank(sumInATM, security);
        }
        return atm;
    }

}
