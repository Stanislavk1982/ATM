package com.java.stanislav_k.atminoffice;

import com.java.stanislav_k.exeption.ErrorSecurity;
import com.java.stanislav_k.exeption.IncorrectCard;
import com.java.stanislav_k.exeption.NotEnougtMoneyInATM;

public interface ATM {

    void setCard(Card card);

    void insertionOfTheCard(Card card) throws IncorrectCard;

    //boolean isTruePaySystem(Card card);

    void enterPicCode(int pinCode) throws ErrorSecurity;

    void windowChoise();

    void windowAccount();

    void windowTransfer() throws NotEnougtMoneyInATM, ErrorSecurity;

    void windowMobile();

    //void cashAdvance(int sum) throws NotEnougtMoneyInATM;

    //void printBill(int sum);

    //static ATM newInstance();
}
