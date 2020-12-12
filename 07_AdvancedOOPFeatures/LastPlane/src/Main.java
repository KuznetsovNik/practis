import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
                .filter(flights -> {
                    LocalDateTime flightTime = LocalDateTime(flights.)
                })
    }
}