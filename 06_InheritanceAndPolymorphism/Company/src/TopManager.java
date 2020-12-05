public class TopManager implements Employee {

    private final int BASIC_SALARY = 70000;

    private Company company;

    @Override
    public int getMonthSalary()
    {
        int salary = BASIC_SALARY;
        if (company.getIncome() > 10000000)
        {
            int bonus = salary * 150 / 100;
            salary += bonus;
        }
        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }


}
