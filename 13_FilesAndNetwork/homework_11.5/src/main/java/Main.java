
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.util.*;

/**
 * Напишите программу, которая:
 2. Парсит полученную страницу и получает из неё:
 Линии московского метро (получаете имя линии, номер линии, цвет парсить не надо).
 Станции московского метро (получаете имя станции, номер линии).
 3. Создаёт и записывает на диск JSON-файл
 4. Читает файл и выводит в консоль количество станций на каждой линии.

 * Для более быстрого поиска нужных селекторов используйте онлайн сервис jsoup https://try.jsoup.org/
 */
public class Main {
    public static final String URL = "https://www.moscowmap.ru/metro.html#lines";
    private static final String DATA_FILE = "src/main/resources/map.json";

    public static void main(String[] args){
        try {
            Metro metro = new Metro();
            Document doc = Jsoup.connect(URL).maxBodySize(0).get();

            Map<String, List<Station>> stations = new HashMap<>();
            List<Line> lines = new ArrayList<>();

            Elements namesOfLines = doc.getElementsByClass("js-metro-line");
            namesOfLines.forEach(element ->
                    lines.add(new Line(element.attr("data-line"),element.text())));

            Elements namesOfStations = doc.getElementsByClass("js-metro-stations");
            namesOfStations.forEach(element -> {
                            List<Station> stationsList = new ArrayList<>();
                            stationsList.add(new Station(element.getElementsByClass("name").text()));
                            stations.put(element.attr("data-line"),stationsList);
                    });
            metro.setStations(stations);
            metro.setLines(lines);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(metro,new FileWriter(DATA_FILE));
            System.out.println(gson.toJson(metro));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
