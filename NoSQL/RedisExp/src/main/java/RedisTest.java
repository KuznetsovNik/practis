
public class RedisTest {
    private static final int USERS = 20;

//    private static void log(int User) {
//        String log = String.format("- На главной странице показываем пользователя %d", User);
//        out.println(log);
//    }

    public static void main(String[] args){
        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int users = 1; users <= USERS; users++) {
            redis.logPageVisit(users);
        }
        for(;;){
            redis.listUsers();
            System.out.println("------------------------");
            redis.lisWithoutDonateUsers();
           try{
               Thread.sleep(1000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
    }
}
