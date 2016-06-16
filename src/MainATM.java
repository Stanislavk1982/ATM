public class MainATM {
    public static void main(String[] args) {
        Card card = new Card();
        ATM atm = new ATM(card);
        Person person = new Person();
        System.out.println("Enter Card");
        try {
            atm.insertionOfTheCard("5610000000000001", "Visa");
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
