package com.java.Stanislav.ATM;

public interface ATMInterface {

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
