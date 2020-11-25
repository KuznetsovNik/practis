public class Entrepreneur extends Individual {

    public Entrepreneur(int accountAmount) {
        super(accountAmount);
    }

    // Предприниматель

    @Override
    public void depositingAccount(int clientDepositing) {
       int commission;
       if (clientDepositing < 1000){
           commission = clientDepositing * 1/100;
           System.out.println("Комиссия при пополнении " + commission + "р.");
           clientDepositing -= commission;
           super.depositingAccount(clientDepositing);
       }else {
           commission = clientDepositing * 1/2/100;
           System.out.println("Комиссия при пополнении " + commission + "р.");
           clientDepositing -= commission;
           super.depositingAccount(clientDepositing);
       }
    }

    @Override
    public void balanceAccount() {
        System.out.println("Баланс на счету ИП : " + getAccountAmount());
    }

    @Override
    public void infoAccount() {
        balanceAccount();
        System.out.println("Для Вас условия снятия без комиссии, но пополнение с комиссией 1%, если сумма меньше 1000 рублей.\n И с комиссией 0,5%, если сумма больше либо равна 1000 рублей ");
    }
}
