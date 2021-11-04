import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    private static final String WEB_SITE_URL = "https://lenta.ru";
    private static final String FOLDER_PATH = "images";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(WEB_SITE_URL).get();
            Elements img = doc.getElementsByTag("img");
            for (Element el : img) {
                String src = el.absUrl("src");
                System.out.println("Image Found! : " + el.attr("alt"));
                try (InputStream in = new URL(src).openStream()) {
                    Files.copy(in, Paths.get(FOLDER_PATH + "/" +
                            new File(src.replaceAll(".*?([^/]*?\\.jpg|\\.jpeg|\\.gif|\\.png|\\.bmp|\\.js).*", "$1"))), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}



