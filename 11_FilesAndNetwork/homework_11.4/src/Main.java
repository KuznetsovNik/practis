import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;

public class Main {
    private static final String WEB_SITE_URL = "https://lenta.ru";
    private static final String FOLDER_PATH = "images";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(WEB_SITE_URL).get();
            Elements img = doc.getElementsByTag("img");

            for (Element el : img) {
                String src = el.absUrl("src");
                System.out.println("Image Found! : " + trim(el.attr("alt"), 20));
                getImages(src);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

    private static void getImages(String src) throws IOException {
        int indexName = src.lastIndexOf("/");
        if (indexName == src.length()) {
            src = src.substring(1, indexName);
        }
        indexName = src.lastIndexOf("/");
        String name = src.substring(indexName);
        System.out.println(name);

        URL url = new URL(src);
        InputStream in = url.openStream();
        // Паттерн Декоратор
        OutputStream out = new BufferedOutputStream(new FileOutputStream(FOLDER_PATH + name));

        for (int b; (b = in.read()) != -1; ) {
            out.write(b);
        }

        out.close();
        in.close();
    }
}




