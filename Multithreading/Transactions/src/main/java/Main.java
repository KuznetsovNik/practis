import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Main {
    private static Map<String, Account> bankMap = new Hashtable<>();
    private static Bank bank = new Bank(bankMap);
    private static ArrayList<Thread> threadList = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            long randomFrom = Math.round(Math.random() * 60000);
            long randomTo = Math.round(Math.random() * 60000);
            Account accountFrom = new Account(Long.toString(randomFrom), randomFrom);
            Account accountTo = new Account(Long.toString(randomTo), randomTo);
            bankMap.put(accountFrom.getAccNumber(), accountFrom);
            bankMap.put(accountTo.getAccNumber(), accountTo);
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("Поток № " + j + " старт:");
                    if (accountFrom != accountTo) {
                        long randomMoney = Math.round(Math.random() * 54000);
                        try {
                            bank.transfer(accountFrom.getAccNumber(), accountTo.getAccNumber(), randomMoney);
                            System.out.println("Поток № " + j + " финиш: Сумма денег в банке " +  bank.getSumAllAccounts());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }));
        }
        threadList.forEach(Thread::start);
        System.out.println("Сумма денег в банке " + bank.getSumAllAccounts());
    }
}