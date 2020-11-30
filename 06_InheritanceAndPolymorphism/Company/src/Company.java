import java.util.*;

public class Company
{
    static private final int BASIC_SALARY = 40000;
    protected int income;
    protected int managers;
    protected int topManagers;
    protected int operators;
    List<Employee> employeeList = new ArrayList<>();

    public Company()
    {
        managers = 0;
        topManagers = 0;
        operators = 0;
    }

    public void hire(String employee)
    {
        if (employee.equals("manager")) {
            Manager manager = new Manager();
            employeeList.add(manager);
        }else if (employee.equals("topmanager")) {
            TopManager topManager = new TopManager();
            employeeList.add(topManager);
        } else if (employee.equals("operator")) {
            Operator operator = new Operator();
            employeeList.add(operator);
        }
        System.out.println(employeeList.size());
    }

    public void hireAll(int numberManager, int numberTopManager, int numberOperator)
    {
        managers = numberManager;
        for (int i = 0; i < numberManager; i++) {
            Manager manager = new Manager();
            employeeList.add(manager);
        }
        topManagers = numberTopManager;
        for (int i = 0; i < numberTopManager; i++) {
            TopManager topManager = new TopManager();
            employeeList.add(topManager);
        }
        operators = numberOperator;
        for (int i = 0; i < numberOperator; i++) {
            Operator operator = new Operator();
            employeeList.add(operator);
        }
        System.out.println(employeeList.size());
    }

    public void fire(String employee)
    {

        if (employee.equals("manager")){
            employeeList.remove(managers);
        } else if (employee.equals("topmanager")){
            employeeList.remove(topManagers);
        } else if (employee.equals("operator")){
            employeeList.remove(operators);
        }
        System.out.println(employeeList.size());
    }

    public int getIncome()
    {
        return income;
    }

    public static int getBasicSalary()
    {
        return BASIC_SALARY;
    }

    List<Employee> getTopSalaryStaff(int count)
    {
        for (Employee list : employeeList){
            System.out.println(list);
        }
        return null;
    }
    List<Employee> getLowestSalaryStaff(int count)
    {
        for (Employee list : employeeList){
            System.out.println(list);
        }
        return null;
    }
}
