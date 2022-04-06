import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class ThreadTest {

    private static Map<String,Account> bankMap = new Hashtable<>();
    private static Bank bank = new Bank(bankMap);
    private static ArrayList<Thread> threadList = new ArrayList<>();

    @Test
    public void threadTest() {
        for (int i = 0; i < 20; i++){
            long randomFrom = Math.round(Math.random() * 60000);
            long randomTo = Math.round(Math.random() * 60000);
            Account accountFrom = new Account(Long.toString(randomFrom),randomFrom);
            Account accountTo = new Account(Long.toString(randomTo),randomTo);
            bankMap.put(accountFrom.getAccNumber(),accountFrom);
            bankMap.put(accountTo.getAccNumber(),accountTo);
            System.out.println("Сумма денег в банке " + bank.getSumAllAccounts());
            threadList.add(new Thread(()->{
                for (int j = 0; j < 5; j++){
                    if (accountFrom != accountTo){
                        long randomMoney = Math.round(Math.random() * 54000);
                        try {
                            bank.transfer(accountFrom.getAccNumber(),accountTo.getAccNumber(),randomMoney);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }));
        }
        threadList.forEach(Thread::start);
        long actual = bank.getSumAllAccounts();
        System.out.println("Сумма денег в банке " + actual);

        assertEquals(bank.getSumAllAccounts(),actual);
    }
}
