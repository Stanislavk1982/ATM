public class ATM {
    private Card card;
    Security security = new Security();
    private boolean cardCorrect = false;
    private boolean authentication = false;

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
    }

}
