public class MainATM {
    public static void main(String[] args) {
        Card card = new Card("5610000000000001", "MC");
        ATM atm = ATM.newInstance();
        atm.setCard(card);
        System.out.println("Enter Card");
        try {
            atm.insertionOfTheCard(card);
        } catch (IncorrectCard incorrectCard) {
            incorrectCard.printStackTrace();
        }
        System.out.println("Enter Pin Code");
        try {
            atm.enterPicCode(5432);
        } catch (ErrorSecurity errorSecurity) {
            errorSecurity.printStackTrace();
        }

    }
}
