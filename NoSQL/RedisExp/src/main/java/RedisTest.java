import java.util.SplittableRandom;
import static java.lang.System.out;

public class RedisTest {
    private static final int USERS = 20;
    private static void log(int User) {
        String log = String.format("- На главной странице показываем пользователя %d", User);
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int users = 1; users <= USERS; users++) {
            redis.logPageVisit(users);
        }
        new Thread(() -> {
            for (;;) {
                redis.listUsers();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            SplittableRandom r = new SplittableRandom();
            for (;;) {
                if (r.nextInt(1,101) <= 50) {
                    int randomUser = r.nextInt(19 + 1) + 1;
                    redis.donate(randomUser);
                    log(randomUser);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
