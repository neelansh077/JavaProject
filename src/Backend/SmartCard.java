package Backend;

public class SmartCard {
    private int cardPin;
    private String cardNum;
    private int balance;
    
    public SmartCard(int cardPin, String cardNum, int balance) {
        this.cardPin = cardPin;
        this.cardNum = cardNum;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCardPin() {
        return cardPin;
    }
    public void setCardPin(int cardPin) {
        this.cardPin = cardPin;
    }
    public String getCardNum() {
        return cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
