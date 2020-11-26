public class Individual extends Client {

    public Individual(int accountAmount){
        this.accountAmount = accountAmount;
    }

    // Физ. лицо


    @Override
    public int balanceAccount() {
        return accountAmount;
    }

    @Override
    public void infoAccount() {
        System.out.println("Для Вас условия снятия и пополнения без комиссии ");
        super.infoAccount();
    }

    @Override
    protected int getWithdrawCommission(int amount) {
        return 0;
    }

    @Override
    protected int getDepositCommission(int amount) {
        return 0;
    }
}
