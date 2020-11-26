public class Entity extends Client {

    public Entity(int accountAmount) {
        this.accountAmount = accountAmount;
    }

    // Юр. лицо

    @Override
    public void withDrawingAccount(int clientDrawing) {
        System.out.println("Комиссия при снятии " + getWithdrawCommission(clientDrawing) + "р.");
        super.withDrawingAccount(clientDrawing);
    }

    @Override
    public int balanceAccount() {
        return accountAmount;
    }


    @Override
    public void infoAccount() {
        System.out.println("Для Вас условия пополнения без комиссии, но 1% комиссии при снятии средств ");
        super.infoAccount();
    }

    @Override
    protected int getWithdrawCommission(int commission) {
        commission = commission * 1/100;
        return commission;
    }

    @Override
    protected int getDepositCommission(int amount) {
        return 0;
    }

}
