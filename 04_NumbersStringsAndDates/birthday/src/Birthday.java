import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Birthday {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(1995, Month.OCTOBER, 27);
        int birthday = 0;
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d %s \n", birthday, now.plus(Period.ofYears(i)).format(DateTimeFormatter.ofPattern("dd.MM.yyyy - EEEE")));
            birthday++;
            if (now.plus(Period.ofYears(i+1)).isAfter(LocalDate.now())){
                break;
            }
        }
    }
}
