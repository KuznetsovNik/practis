import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParserUtils {
    static HashSet<String> uniqueUrl = new HashSet<>();
    static String mySite = "https://lenta.ru/";
    static Integer i = 1;

    public static List<String> parserUtils(String url) {
        List<String> listLinks = new ArrayList<>();
        try {
            Thread.sleep(100);
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .timeout(0)
                    .get();
            Elements link = document.select("a");
            if (!link.isEmpty()){
                for(Element element : link){
                    String thisUrl = element.attr("href");
                    synchronized (uniqueUrl){
                        if (!thisUrl.contains("#")
                                && !uniqueUrl.contains(thisUrl)
                                && thisUrl.startsWith(mySite)
                                && thisUrl.endsWith("/")
                                ){
                            uniqueUrl.add(thisUrl);
                            listLinks.add(getTubs(i) + thisUrl);
                        }

                    }
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listLinks;
    }

    public static String getTubs(int tubsCount){
        return " " + " ".repeat(Math.max(0, tubsCount));
    }
}
