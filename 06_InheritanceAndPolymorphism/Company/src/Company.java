import java.util.*;

public class Company
{
    private final List<Employee> employeeList = new ArrayList<>();

    public static int getIncome() {
        return 12000000;
    }

    public void hire(Employee employee)
    {
        this.employeeList.add(employee);
    }

    public void hireAll(List<Employee> employeeList)
    {
        this.employeeList.addAll(employeeList);
    }

    public void fire(Employee employee)
    {
        employeeList.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count)
    {
        return getLimitedFilteredList(count, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });
    }

    public List<Employee> getLowestSalaryStaff(int count)
    {
        return getLimitedFilteredList(count, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });
    }

    private List<Employee> getLimitedFilteredList (int count , Comparator<Employee> comparator){
        List<Employee> copyList = new ArrayList<Employee>(employeeList);
        Collections.sort(copyList , comparator);
        List<Employee> result = new ArrayList<Employee>();
        for (int i = 0; i < count; i++){
            result.add(copyList.get(i));
        }
        return result;
    }

    public int countEmployees(){
        return employeeList.size();
    }

    public List<Employee> getEmployees(){
        return employeeList;
    }

}
