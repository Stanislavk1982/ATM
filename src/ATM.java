import java.util.Calendar;
import java.util.Scanner;

public class ATM {
    private Card card;
    Security security = new Security();
    private boolean cardCorrect = false;
    private boolean authentication = false;
    private int pinCode;
    private int sumInATM = 1234567;

    public ATM(Card card) {
        this.card = card;
    }

    public void insertionOfTheCard(String idCard, String paymentSystem) throws IncorrectCard {
        boolean sensorOfTheReader = true;
        if (!sensorOfTheReader) {
            throw new IncorrectCard("You inserted not banking card");
        }
        if (paymentSystem.equals("MC") || paymentSystem.equals("Visa")) {
            card.setPaymentSystem(paymentSystem);
        } else
            throw new IncorrectCard("This Payment system isn't supported");

        if (!card.checkCorrectNumber(idCard)) {
            throw new IncorrectCard("You Card is fake");
        } else {
            card.setIdCard(idCard);
        }
        cardCorrect = true;
    }

    public void enterPicCode(int pinCode) throws ErrorSecurity {
        if (pinCode < 999 || pinCode > 9999999) {
            throw new ErrorSecurity("You enter incorrect PinCode");
        }
        if (!security.pinCodForCard(pinCode)) {
            throw new ErrorSecurity("You PinCode isn't true");
        }
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
        String choise = scanner.next();
        switch (choise) {
            case "1":
                windowAccount();
                break;
            case "2":
                try {
                    windowTransfer();
                } catch (NotEnougtMoneyInATM notEnougtMoneyInATM) {
                    notEnougtMoneyInATM.printStackTrace();
                }

                break;

        }
    }

    public void windowAccount() {
        System.out.println("Sum on Account is : " + security.moneyAccount(card, pinCode));

    }

    public void windowTransfer() throws NotEnougtMoneyInATM {
        System.out.println("Enter sum which you want to get");
        Scanner scanner = new Scanner(System.in);
        String enterSum = scanner.next();
        int sum = Integer.getInteger(enterSum);
        if (security.moneyTransfer(card, pinCode, sum)) {
            cashAdvance(sum);
        }
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

}
