import java.util.List;
import java.util.concurrent.ForkJoinPool;


public class Main {
    public static final String WEB_SITE_URL = "https://lenta.ru/";

    public static void main(String[] args) {

        List<String> result = new ForkJoinPool().invoke(new LinksTasking(WEB_SITE_URL));
        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}
