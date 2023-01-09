
public class RedisTest {
    private static final int USERS = 20;

    public static void main(String[] args){
        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int users = 1; users <= USERS; users++) {
            redis.logPageVisit(users);
        }
        for(;;){
            redis.listUsers();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
