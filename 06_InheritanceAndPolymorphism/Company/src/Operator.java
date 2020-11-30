public class Operator extends Company implements Employee{

    @Override
    public int getMonthSalary()
    {
        return getBasicSalary();
    }
}
