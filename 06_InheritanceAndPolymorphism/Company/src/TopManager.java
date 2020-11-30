public class TopManager extends Company implements Employee {

    @Override
    public int getMonthSalary()
    {
        int salary = getMonthSalary();
        if (getIncome() > 10000000)
        {
            int bonus = salary * 150 / 100;
            salary += bonus;
        }
        return salary;
    }
}
