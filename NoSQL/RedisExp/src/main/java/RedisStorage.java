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

    private double getTs() {
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
    void donate(){
        Random r = new Random();
        int userId = r.nextInt(19 + 1) + 1;
        out.println("Пользователь " + userId + " оплатил платную услугу");
        out.println("- На главной странице показываем пользователя " + userId);
        usersMeetingWebsite.addScoreAsync(String.valueOf(userId) , getTs());
    }
    public void listUsers() {
        for (String user : usersMeetingWebsite){
            out.println("- На главной странице показываем пользователя " + user);
            usersMeetingWebsite.addScoreAsync(user, getTs());
        }
    }
    void shutdown() {
        redisson.shutdown();
    }

}
