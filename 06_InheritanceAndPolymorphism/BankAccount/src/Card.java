public class Card extends BankAccount {

    public Card(int moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public void withDrawing(int withDrawingAmount){
        int commission;
        commission = withDrawingAmount * 1/100;
        System.out.println("Комиссия при снятии " + commission + "р.");
        withDrawingAmount += commission;
        super.withDrawing(withDrawingAmount);
    }
}
