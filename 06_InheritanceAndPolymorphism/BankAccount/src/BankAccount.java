public class BankAccount {

    private int moneyAmount;

    public BankAccount(int moneyAmount){
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void withDrawing(int withDrawingAmount){
        if (moneyAmount >= withDrawingAmount){
            moneyAmount -= withDrawingAmount;
        }else {
            System.out.println("Недостаточно средств для снятия!");
        }
    }

    public void depositing(int depositingAmount){
        moneyAmount += depositingAmount;
    }

    public void balance(){
        System.out.println(moneyAmount);
    }

    boolean send(BankAccount receiver,int amount){
        if (receiver.getMoneyAmount() >= amount) {
            receiver.withDrawing(amount);
            moneyAmount += amount;
            System.out.println("Перевод выполнен");
            return true;
        } else {
            System.out.println("Перевод не выполнен, не достаточно средств");
            return false;
        }
    }

}
