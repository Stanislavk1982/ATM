public class Account {
    public Account(String idCard, double sum, int pinCode) {
        this.idCard = idCard;
        this.sum = sum;
        this.pinCode = pinCode;
    }

    private String idCard;
    private double sum;
    private int pinCode;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
