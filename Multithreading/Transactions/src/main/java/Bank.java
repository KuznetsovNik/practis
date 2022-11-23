import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();
    private Lock lock = new ReentrantLock();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        System.out.println("Идёт проверка...");
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public boolean isEnoughMoney(Account fromBalance, long amount){
        return fromBalance.getMoney() >= amount;
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);
        System.out.printf("Запрос на перевод с %s на %s сумму %d \n", from.getAccNumber(), to.getAccNumber(), amount);
        Account lowSynchro;
        Account topSynchro;

        if (from.equals(to)) {
            lowSynchro = from;
            topSynchro = to;
        } else {
            lowSynchro = to;
            topSynchro = from;
        }
        if (isEnoughMoney(from, amount)) {
            if (amount > 50000 || isFraud(fromAccountNum, toAccountNum, amount)) {
                System.out.println("Счета " + from.getAccNumber() + " заблокированы");
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
                System.out.println("Счета " + from.getAccNumber() + " разблокированы, проверка произведена");
            } else {
                synchronized (lowSynchro) {
                    long balanceFrom = from.getMoney() - amount;
                    synchronized (topSynchro) {
                        long totalTo = to.getMoney() + amount;
                        from.setMoney(balanceFrom);
                        to.setMoney(totalTo);
                    }
                }
                System.out.printf("Перевод с %s на %s сумму %d СОВЕРШЁН \n", from.getAccNumber(), to.getAccNumber(), amount);

            }
        }else {
            System.out.println("На счёте недостаточно средств");
        }
    }

    public long getBalance(String accountNum) {
        System.out.printf("Номер счёта %s, баланс: ", accountNum);
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long totalSum = 0;
        for (String key : accounts.keySet()) {
            totalSum += accounts.get(key).getMoney();
        }
        return totalSum;
    }


}
