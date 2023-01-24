import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;
import java.text.ParseException;

public class XMLHandler extends DefaultHandler {
    int limit = 5_000_000;
    int number = 0;
    private Loader loader;

    public XMLHandler() {
        loader = new Loader();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter") && number < limit) {
//            System.out.println("Проходим по парсеру " + attributes.getValue("name") + " др " + attributes.getValue("birthDay"));
            try {
                loader.storingVotesToDB(attributes.getValue("name"), attributes.getValue("birthDay"));
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
            }
            number++;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            loader.loadLastData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

        //        try {
//            if (qName.equals("voter") && voter == null){
//                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
//                String birthDay = attributes.getValue("birthDay");
//                String name = attributes.getValue("name");
//                DBConnection.incrementCountBuilder(name,birthDay);
//                voter = new Voter(attributes.getValue("name"),birthDay);
//            }else if (qName.equals("visit") && voter != null) {
//            int count = voterCounts.getOrDefault(voter, 0);
//            voterCounts.put(voter, count + 1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    //    public void storingVotesToDB() throws SQLException {
//        for (Voter voter : voterCounts.keySet()){
//            DBConnection.incrementCountBuilder(voter.getName(), birthDayFormat.format(voter.getBirthDay()));
//        }
//    }




