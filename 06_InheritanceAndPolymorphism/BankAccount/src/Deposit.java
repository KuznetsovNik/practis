import java.time.LocalDate;

public class Deposit extends BankAccount {

    public LocalDate dateDepositing;

    public Deposit(int moneyAmount) {
        super(moneyAmount);
    }

    @Override
    public void depositing(int depositingAmount){
        super.depositing(depositingAmount);
        dateDepositing = LocalDate.now();
    }

    @Override
    public void withDrawing(int withDrawingAmount){
        LocalDate dateDrawing = LocalDate.now();
        if (dateDrawing.minusMonths(1).isBefore(dateDepositing)){
            System.out.print("Отказано в снятии - не прошёл месяц с момента вклада - ");
            System.out.println(dateDepositing);
        }else {
            super.withDrawing(withDrawingAmount);
        }
    }

}
