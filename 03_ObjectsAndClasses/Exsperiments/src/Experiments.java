
import com.skillbox.airport.Airport;
import java.lang.String;

public class Experiments {

    public static void main(String[] args) {
        Airport aircraft = Airport.getInstance();
        System.out.println(aircraft.getAllAircrafts());
        System.out.println(Integer.valueOf(aircraft.getAllAircrafts().size()));

    }
}
