public class Operator implements Employee{

    private final int BASIC_SALARY = 30000;

    private Company company;

    @Override
    public int getMonthSalary()
    {
        return BASIC_SALARY;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

}
