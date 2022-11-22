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

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        System.out.printf("Запрос на перевод с %s на %s сумму %d \n",fromAccountNum,toAccountNum,amount);
        Account from = accounts.get(fromAccountNum);
        Account to = accounts.get(toAccountNum);

        if (amount <= 50000) {
            if (from.getMoney() >= amount) {
                synchronized (from){
                    synchronized (to) {
                        long balanceFrom = from.getMoney() - amount;
                        long totalTo = to.getMoney() + amount;
                        from.setMoney(balanceFrom);
                        to.setMoney(totalTo);
                    }
                }
                System.out.printf("Перевод с %s на %s сумму %d СОВЕРШЁН \n",fromAccountNum,toAccountNum,amount);
            }else {
                System.out.println("На счёте недостаточно средств");
            }
        } else if (isFraud(fromAccountNum, toAccountNum, amount)){
            System.out.println("Счета заблокированы");
            lock.lock();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        } else {
            if (from.getMoney() >= amount) {
                synchronized (from) {
                    synchronized (to) {
                        long balanceFrom = accounts.get(fromAccountNum).getMoney() - amount;
                        long totalTo = accounts.get(toAccountNum).getMoney() + amount;
                        from.setMoney(balanceFrom);
                        to.setMoney(totalTo);
                    }
                }
                System.out.printf("Перевод с %s на %s сумму %d СОВЕРШЁН \n",fromAccountNum,toAccountNum,amount);
            }else {
                System.out.println("На счёте недостаточно средств");
            }
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
