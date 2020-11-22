public class Card extends BankAccount {

    public int commission;

    public Card(int moneyAmount) {
        super(moneyAmount);
    }

    public void withDrawing(int withDrawingAmount){
        commission = withDrawingAmount * 1/100;
        System.out.println("Комиссия при снятии " + commission + "р.");
        withDrawingAmount += commission;
        moneyAmount -= withDrawingAmount;
    }
}
