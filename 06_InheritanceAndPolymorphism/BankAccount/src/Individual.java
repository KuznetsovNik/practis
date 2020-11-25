public class Individual extends Client {

    private int accountAmount;

    public Individual(int accountAmount){
        this.accountAmount = accountAmount;
    }

    public int getAccountAmount() {
        return accountAmount;
    }

    // Физ. лицо
    @Override
    public void depositingAccount(int clientDepositing) {
        accountAmount += clientDepositing;
    }

    @Override
    public void withDrawingAccount(int clientDrawing) {
        if (accountAmount >= clientDrawing){
            accountAmount -= clientDrawing;
        }else {
            System.out.println("Недостаточно средств для снятия!");
        }
    }

    @Override
    public void balanceAccount() {
        System.out.println("Баланс на счету Физ. лица : " + accountAmount);
    }

    @Override
    public void infoAccount() {
        balanceAccount();
        System.out.println("Для Вас условия снятия и пополнения без комиссии ");
    }
}
