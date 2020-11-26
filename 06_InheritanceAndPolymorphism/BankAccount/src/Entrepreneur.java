public class Entrepreneur extends Client {

    public Entrepreneur(int accountAmount) {
        this.accountAmount = accountAmount;
    }

    // Предприниматель

    @Override
    public int balanceAccount() {
        return accountAmount;
    }

    @Override
    public void infoAccount() {
        System.out.println("Для Вас условия снятия без комиссии, но пополнение с комиссией 1%, если сумма меньше 1000 рублей.\n И с комиссией 0,5%, если сумма больше либо равна 1000 рублей ");
        super.infoAccount();
    }

    @Override
    protected int getWithdrawCommission(int amount) {
        return 0;
    }

    @Override
    protected int getDepositCommission(int amount) {
        int commission;
        if (amount < 1000){
            commission = amount * 1/100;
            System.out.println("Комиссия при пополнении " + commission + "р.");
        }else {
            commission = amount * 1/2/100;
            System.out.println("Комиссия при пополнении " + commission + "р.");
        }
        return commission;
    }
}
