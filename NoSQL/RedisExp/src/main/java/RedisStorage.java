import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import java.util.Date;
import java.util.Random;
import static java.lang.System.out;

public class RedisStorage {
    private RedissonClient redisson;
    private RScoredSortedSet<String> usersMeetingWebsite;
    private final static String KEY = "USERS";
    private long getTs() {
        return new Date().getTime() / 1000;
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        usersMeetingWebsite = redisson.getScoredSortedSet(KEY);
    }
    void logPageVisit(int user_id) {
            usersMeetingWebsite.add(getTs(), String.valueOf(user_id));
    }
    void donate(String user){
        out.println("Пользователь " + user + " оплатил платную услугу");
        out.println("- На главной странице показываем пользователя " + user);
        double scoreLast = usersMeetingWebsite.lastScore();
        usersMeetingWebsite.addScoreAsync(user, scoreLast + getTs());
    }
    public void listUsers() {
        int countUser = 0;
        int repeatFirst = 0;
        int repeatSecond = 0;
        for (String user : usersMeetingWebsite){
            Random r = new Random();
            String userId = String.valueOf(r.nextInt(19 + 1) + 1);
            if (countUser == 5) {
                donate(userId);
                repeatFirst = Integer.parseInt(userId);
            }else if (countUser == 15){
                donate(userId);
                repeatSecond = Integer.parseInt(userId);
            }
            if (repeatFirst != Integer.parseInt(user) && repeatSecond != Integer.parseInt(user)) {
                out.println("- На главной странице показываем пользователя " + user);
                usersMeetingWebsite.addScoreAsync(user, getTs() + 1);
            }
            countUser++;
        }
    }

    void shutdown() {
        redisson.shutdown();
    }
}