public class Manager extends Company implements Employee{

    public Manager()
    {
        income += moneyEarned;
    }

    int lowerEarned = 115000;
    int highEarned = 140000;
    int moneyEarned = lowerEarned + (int) (Math.random() * highEarned);

    @Override
    public int getMonthSalary()
    {
        int salary = getBasicSalary();
        int perсentEarned = moneyEarned * 5 / 100;
        salary += perсentEarned;
        return salary;
    }

}