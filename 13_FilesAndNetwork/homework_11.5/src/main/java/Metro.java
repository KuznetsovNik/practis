import java.util.*;

public class Metro {

    public  List<Line> lines;
    public  Map<String,List<Station>> stations;

    public Metro() {
        lines = new ArrayList<>();
        stations = new HashMap<>();
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Map<String, List<Station>> getStations() {
        return stations;
    }

    public void setStations(Map<String, List<Station>> stations) {
        this.stations = stations;
    }

}
