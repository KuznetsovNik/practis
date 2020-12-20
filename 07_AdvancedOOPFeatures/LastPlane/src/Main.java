import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;


public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime twoHoursLater = nowTime.plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");

        System.out.println("Local time: " + nowTime.getHour() + ":" + nowTime.getMinute());

        airport.getTerminals()
                .stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> {
                    LocalDateTime tmp = flight.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return tmp.isAfter(nowTime) && tmp.isBefore(twoHoursLater);
                }).forEach(flight -> {
                    LocalDateTime tmp = flight.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    System.out.println(flight.getAircraft().getModel() + "\t" + tmp.format(formatter));
                });
    }
}