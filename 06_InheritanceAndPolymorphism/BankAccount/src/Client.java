public abstract class Client {

    protected int accountAmount;

    public void depositingAccount(int clientDepositing){
        int totalWithCommission = clientDepositing - getDepositCommission(clientDepositing);
        this.accountAmount += totalWithCommission;
    }

    public void withDrawingAccount(int clientDrawing){
        if (accountAmount >= clientDrawing){
            int amountWithCommission = clientDrawing + getWithdrawCommission(clientDrawing);
            this.accountAmount -= amountWithCommission;
        }else {
            System.out.println("Недостаточно средств для снятия!");
        }
    }

    abstract public int balanceAccount();

    public void infoAccount(){
        balanceAccount();
    }

    protected abstract int getWithdrawCommission(int amount);

    protected abstract int getDepositCommission(int amount);

}
