import java.util.Calendar;

public class Security {
    public Security() {
    }

    Bank bank = new Bank();

    public boolean pinCodForCard(int pinCode) {
        if (pinCode == 54321) {
            return true;
        }
        return false;
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
    public double moneyAccount(Card card, int pinCode) {
        if (pinCodForCard(pinCode)) {
            return bank.checkSum(card);
        }
        return -1;
    }

    public boolean moneyTransfer(Card card, int pincode, int sum) {
        if (pinCodForCard(pincode)) {
            return bank.getMoneyFromAccount(card,sum);
        }
        return false;
    }
}
