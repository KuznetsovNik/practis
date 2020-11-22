import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Deposit extends BankAccount {

    Calendar calendar = new GregorianCalendar();
    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    public Date dateDepositing;

    public Deposit(int moneyAmount) {
        super(moneyAmount);
    }

    public void depositing(int depositingAmount){
        moneyAmount += depositingAmount;
        dateDepositing = calendar.getTime();
        calendar.roll(Calendar.MONTH , +1);
    }

    public void withDrawing(int withDrawingAmount){
        Date dateDrawing = calendar.getTime();
        if (dateDrawing.after(dateDepositing)){
            System.out.println("Отказано в снятии - не прошёл месяц с момента вклада");
            System.out.println(formater.format(dateDepositing));
        }else {
            moneyAmount -= withDrawingAmount;
        }
    }

}
