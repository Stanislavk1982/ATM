import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccount() {
        return accounts;
    }

    public void setAccount(List<Account> accounts) {
        this.accounts = accounts;
    }

    public double checkSum(Card card) {
        for (Account account : accounts) {
            if (account.getIdCard() == card.getIdCard()) {
                return account.getSum();
            }
        }
        return -1;
    }

    public boolean getMoneyFromAccount(Card card, int sum) {
        for (Account acoount : accounts) {
            if (acoount.getIdCard() == card.getIdCard() && acoount.getSum() > sum) {
                acoount.setSum(acoount.getSum() - sum);
                return true;
            }
        }
        return false;
    }
}

