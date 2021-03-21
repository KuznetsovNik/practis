import core.Line;
import core.Station;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

public class RouteCalculatorTest {

    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    List<Station> route;
    List<Station> routeWithOneChange;
    List<Station> routeWithTwoChanges;

    Line line1 , line2, line3;
    Station st1 , st2 , st3 , st4 , st5 , st6, st7 , st8 , st9;

    /**
     *  Северная Линия (line1)        Центральная Линия (line2)       Южная Линия (line3)
     *         |                                  |                             |
     *         | st1 -       - пересадка -      - | st4                         | st7
     *         |                                  |                             |
     *         |                                  |                             |
     *         | st2                              | st5                         | st8
     *         |                                  |                             |
     *         |                                  |                             |
     *         | st3                              | st6  -    - пересадка -   - | st9
     */
    @Before
    public void setUp() throws Exception {
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        line1 = new Line(1 , "Северная");
        line2 = new Line(2 , "Центральная");
        line3 = new Line(3 , "Южная");

        st1 = new Station("Авиастроительная" , line1);
        st2 = new Station("Стадион" , line1);
        st3 = new Station("Мега" , line1);
        st4 = new Station("Вокзал" , line2);
        st5 = new Station("Кремлёвская" , line2);
        st6 = new Station("Проспект победы" , line2);
        st7 = new Station("Адмиралтейская" , line3);
        st8 = new Station("Цум" , line3);
        st9 = new Station("Дубравная" , line3);

        // North line
        stationIndex.addLine(line1);
        stationIndex.addStation(st1);
        line1.addStation(st1);
        stationIndex.addStation(st2);
        line1.addStation(st2);
        stationIndex.addStation(st3);
        line1.addStation(st3);

        // Central line
        stationIndex.addLine(line2);
        stationIndex.addStation(st4);
        line2.addStation(st4);
        stationIndex.addStation(st5);
        line2.addStation(st5);
        stationIndex.addStation(st6);
        line2.addStation(st6);

        // South line
        stationIndex.addLine(line3);
        stationIndex.addStation(st7);
        line3.addStation(st7);
        stationIndex.addStation(st8);
        line3.addStation(st8);
        stationIndex.addStation(st9);
        line3.addStation(st9);

        // Transfers
        List<Station> change1LineTo2 = new ArrayList<>();
        change1LineTo2.add(st1);
        change1LineTo2.add(st4);
        stationIndex.addConnection(change1LineTo2);

        List<Station> change2LineTo3 = new ArrayList<>();
        change2LineTo3.add(st6);
        change2LineTo3.add(st9);
        stationIndex.addConnection(change2LineTo3);

        route = new ArrayList<>();
        route.add(st5);
        route.add(st6);
        route.add(st4);

        routeWithOneChange = new ArrayList<>();
        routeWithOneChange.add(st1);
        routeWithOneChange.add(st2);
        routeWithOneChange.add(st5);
        routeWithOneChange.add(st4);

        routeWithTwoChanges = new ArrayList<>();
        routeWithTwoChanges.add(st1);
        routeWithTwoChanges.add(st4);
        routeWithTwoChanges.add(st2);
        routeWithTwoChanges.add(st5);
        routeWithTwoChanges.add(st9);
        routeWithTwoChanges.add(st8);
        routeWithTwoChanges.add(st6);
    }

    @Test
    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(routeWithTwoChanges);
        double expected = 17.0;  // route 5.0 ; routeWithOneChange 8.5; routeWithTwoChanges 17.0
        assertEquals(expected , actual);
    }

    @Test
    public void testGetShortestRoute(){
        List<Station> actual = routeCalculator.getShortestRoute(st4 , st6);
        List<Station> expected = new ArrayList<>();
        expected.add(st4);
        expected.add(st5);
        expected.add(st6);
        assertEquals(expected , actual);
    }

    @Test
    public void testGetShortestRouteWithOneChange(){
        List<Station> actual = routeCalculator.getShortestRoute(st2 , st5);
        List<Station> expected = new ArrayList<>();
        expected.add(st2);
        expected.add(st1);
        expected.add(st4);
        expected.add(st5);
        assertEquals(expected , actual);
    }

    @Test
    public void testGetShortestRouteWithTwoChanges(){
        List<Station> actual = routeCalculator.getShortestRoute(st8 , st2);
        List<Station> expected = new ArrayList<>();
        expected.add(st8);
        expected.add(st9);
        expected.add(st6);
        expected.add(st5);
        expected.add(st4);
        expected.add(st1);
        expected.add(st2);
        assertEquals(expected , actual);
    }
}
