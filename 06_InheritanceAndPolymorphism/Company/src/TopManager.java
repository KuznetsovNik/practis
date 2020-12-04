public class TopManager implements Employee {

    private final int BASIC_SALARY = 70000;

    @Override
    public int getMonthSalary()
    {
        int salary = BASIC_SALARY;
        if (Company.getIncome() > 10000000)
        {
            int bonus = salary * 150 / 100;
            salary += bonus;
        }
        return salary;
    }


}
