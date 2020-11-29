public abstract class Client {


    protected int accountAmount;

    public Client(int accountAmount) {
        this.accountAmount = accountAmount;
    }

    public int getAccountAmount() {
        return accountAmount;
    }

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

    public int balanceAccount(){
        return getAccountAmount();
    }

    public void infoAccount(){
        System.out.println(balanceAccount());
    }

    protected abstract int getWithdrawCommission(int amount);

    protected abstract int getDepositCommission(int amount);

}
