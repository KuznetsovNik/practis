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
        long start = System.currentTimeMillis();
        parseFile(fileName);
        System.out.println(" Parsing duration " + (System.currentTimeMillis() - start) + " ms");
        DBConnection.printVoterCounts();
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









    //Loader
//    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
//    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
//    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

   // main old body
//        handler.printDuplicatedVotes();
//
//        //Printing results
//        System.out.println("Voting station work times: ");
//        for (Integer votingStation : voteStationWorkTimes.keySet()) {
//            WorkTime workTime = voteStationWorkTimes.get(votingStation);
//            System.out.println("\t" + votingStation + " - " + workTime);
//        }
//
//        System.out.println("Duplicated voters: ");
//        for (Voter voter : voterCounts.keySet()) {
//            Integer count = voterCounts.get(voter);
//            if (count > 1) {
//                System.out.println("\t" + voter + " - " + count);
//            }
//        }

    //parse old body
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(new File(fileName));
//        DBConnection.printVoterCounts();
//        findEqualVoters(doc);
//        fixWorkTimes(doc);

    //findEqualVoters oldbody
//        NodeList voters = doc.getElementsByTagName("voter");
//        int votersCount = voters.getLength();
//        for (int i = 0; i < votersCount; i++) {
//            Node node = voters.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            String name = attributes.getNamedItem("name").getNodeValue();
//            String birthDay = attributes.getNamedItem("birthDay").getNodeValue();
//            Date birthDay = birthDayFormat
//                .parse(attributes.getNamedItem("birthDay").getNodeValue());
//
//            DBConnection.incrementCountBuilder(name,birthDay);
//            Voter voter = new Voter(name, birthDay);
//            Integer count = voterCounts.get(voter);
//            voterCounts.put(voter, count == null ? 1 : count + 1);

    //fixWorkTimes old body
//        NodeList visits = doc.getElementsByTagName("visit");
//        int visitCount = visits.getLength();
//        for (int i = 0; i < visitCount; i++) {
//            Node node = visits.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
//            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
//            WorkTime workTime = voteStationWorkTimes.get(station);
//            if (workTime == null) {
//                workTime = new WorkTime();
//                voteStationWorkTimes.put(station, workTime);
//            }
//            workTime.addVisitTime(time.getTime());