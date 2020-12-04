public class Manager implements Employee{


    private final int BASIC_SALARY = 50000;
    private int lowerEarned = 115000;
    private int highEarned = 140000;
    private int moneyEarned = lowerEarned + (int) (Math.random() * highEarned);

    @Override
    public int getMonthSalary()
    {
        int salary = BASIC_SALARY;
        int perсentEarned = moneyEarned * 5 / 100;
        salary += perсentEarned;
        return salary;
    }

}