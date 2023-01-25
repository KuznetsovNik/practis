import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Loader {
    DBConnection dbConnection;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");

    public Loader() {
        dbConnection = new DBConnection();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";
        long startParsing = System.currentTimeMillis();
        parseFile(fileName);
        System.out.println(" Parsing duration " + (System.currentTimeMillis() - startParsing) + " ms");
        long startFinding = System.currentTimeMillis();
        DBConnection.printVoterCounts();
        System.out.println(" Find duplicate duration " + (System.currentTimeMillis() - startFinding) + " ms");
    }

    private static void parseFile(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
    }

    public void storingVotesToDB(String name, String birthDay) throws ParseException, SQLException {
        Voter voter = new Voter(name, birthDayFormat.parse(birthDay));
        DBConnection.incrementCountBuilder(voter.getName(), birthDayFormat.format(voter.getBirthDay()));
    }

    public void loadLastData() throws SQLException {
        DBConnection.storingLastData();
    }
}