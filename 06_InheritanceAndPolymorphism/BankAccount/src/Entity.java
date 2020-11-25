public class Entity extends Individual {

    public Entity(int accountAmount) {
        super(accountAmount);
    }

    // Юр. лицо

    @Override
    public void withDrawingAccount(int clientDrawing) {
        int commission;
        commission = clientDrawing * 1/100;
        System.out.println("Комиссия при снятии " + commission + "р.");
        clientDrawing += commission;
        super.withDrawingAccount(clientDrawing);
    }

    @Override
    public void balanceAccount() {
        System.out.println("Баланс на счету Юр. лица : " + getAccountAmount());
    }

    @Override
    public void infoAccount() {
        balanceAccount();
        System.out.println("Для Вас условия пополнения без комиссии, но 1% комиссии при снятии средств ");
    }
}
