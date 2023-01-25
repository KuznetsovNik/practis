import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;
import java.text.ParseException;

public class XMLHandler extends DefaultHandler {
    int limit = 3_000_000;
    int number = 0;
    private Loader loader;

    public XMLHandler() {
        loader = new Loader();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter") && number < limit) {
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
