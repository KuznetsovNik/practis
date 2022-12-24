import org.redisson.Redisson;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import javax.swing.*;
import java.util.Date;
import static java.lang.System.out;

public class RedisStorage {
    private RedissonClient redisson;
    private RScoredSortedSet<String> onlineUsers;
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
        onlineUsers = redisson.getScoredSortedSet(KEY);
    }

    void logPageVisit(int user_id) {
        onlineUsers.add(getTs(), String.valueOf(user_id));
    }

    void donate(int user_id){
        out.println("Пользователь " + user_id + " оплатил платную услугу");
        onlineUsers.addScoreAsync(String.valueOf(user_id), getTs());
    }
    public void listUsers() {
        for(String user : onlineUsers){
            System.out.println("- На главной странице показываем пользователя " + user);
        }
    }

    void shutdown() {
        redisson.shutdown();
    }
}
