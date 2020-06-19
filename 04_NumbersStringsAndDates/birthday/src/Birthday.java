import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Birthday {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE");
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(1995, Month.OCTOBER, 27);
        int birthday = 0;
        while (now.isBefore(LocalDate.now())){
            now = now.plusYears(1);
            System.out.printf("%d %s \n", birthday, now.format(DATE_FORMAT));
            birthday++;
        }
    }
}
