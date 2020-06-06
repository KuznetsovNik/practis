import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Birthday {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEEE");
        GregorianCalendar calendar = new GregorianCalendar(1995, Calendar.OCTOBER , 27);
        int birthday = 0;
        for (int i = 0; i < 25; i++) {
            System.out.printf("%d %s \n" , birthday, dateFormat.format(calendar.getTime()));
            birthday++;
            calendar.add(1, Calendar.YEAR);
        }
    }
}
