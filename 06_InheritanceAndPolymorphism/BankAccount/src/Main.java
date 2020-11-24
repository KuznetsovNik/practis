public class Main {
    public static void main(String[] args) {
        // Тест Класса BankAccount
        BankAccount oleg = new BankAccount(0);
        oleg.depositing(500);
        oleg.withDrawing(4500);
        System.out.println("Баланс на счете в рублях:");
        oleg.balance();

        System.out.println();

        // Тест Класса Deposit
        Deposit sber = new Deposit(0);
        sber.depositing(2000);
        sber.withDrawing(1000);
        System.out.println("Баланс депозита в рублях:");
        sber.balance();

        System.out.println();

        // Тест Класса Card
        Card visa = new Card(0);
        visa.depositing(1000);
        visa.withDrawing(300);
        System.out.println("Баланс на карте в рублях:");
        visa.balance();

        System.out.println();

        // Тест метода перевода денег со счёта на счёт
        visa.send(oleg , 500);
        oleg.send(sber, 10000);
    }
}
