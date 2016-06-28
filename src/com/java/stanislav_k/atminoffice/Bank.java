package com.java.stanislav_k.atminoffice;

import java.util.List;

public interface Bank {

    List<Account> getAccount();

    void setAccount(List<Account> accounts);

    double checkSum(Card card);

    boolean getMoneyFromAccount(Card card, int sum);
}
