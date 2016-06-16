import java.util.Calendar;

public class Security {
    public Security() {
    }

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
}
