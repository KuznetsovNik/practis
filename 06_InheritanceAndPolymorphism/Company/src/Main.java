public class Main {
    public static void main(String[] args)
    {
        Company bmw = new Company();
        hireEmployees(bmw);
        printHighestSalaries(bmw);
        printLowestSalaries(bmw);
        fireHalfEmployees(bmw);
        printHighestSalaries(bmw);
        printLowestSalaries(bmw);
    }

    private static void printHighestSalaries(Company company){
        System.out.println("Список самых высоких зарплат компании BMW:");
        for (Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee.getMonthSalary());
        }
    }

    private static void printLowestSalaries(Company company){
        System.out.println("Список самых низких зарплат компании BMW:");
        for (Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }
    }

    private static void fireHalfEmployees(Company company){
        int countEmployees = company.countEmployees();
        for (int i = 0; i < countEmployees / 2; i++){
            int index = (int) (Math.random() * company.countEmployees());
            Employee badEmployees = company.getEmployees().get(index);
            company.fire(badEmployees);
        }
        System.out.println("Уволено: " + countEmployees / 2 + " сотрудников");
    }

    private static void hireEmployees(Company company){
        for (int i = 0; i < 180; i++){
            Employee operator = new Operator();
            company.hire(operator);
        }
        for (int i = 0; i < 80; i++){
            Employee manager = new Manager();
            company.hire(manager);
        }
        for (int i = 0; i < 10; i++){
            Employee topManager = new TopManager();
            company.hire(topManager);
        }
        System.out.println("Добавлено сотрудников:" + company.countEmployees());
    }
}






















/**
 Для демонстрации и тестирования работы ваших классов:
 Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager.
 Распечатайте список из 10–15 самых высоких зарплат в компании.
 Распечатайте список из 30 самых низких зарплат в компании.
 Увольте 50% сотрудников.
 Распечатайте список из 10–15 самых высоких зарплат в компании.
 Распечатайте список из 30 самых низких зарплат в компании.

 Примеры вывода списка зарплат
 Список из пяти зарплат по убыванию:
 230 000 руб.
 178 000 руб.
 165 870 руб.
 123 000 руб.
 117 900 руб.

 Рекомендации
 Можно создавать разные экземпляры компании со своим списком сотрудников и доходом.
 Чтобы получить данные компании внутри класса сотрудника,
 настройте хранение ссылки на Company и передавайте объект Company с помощью конструктора или сеттера.
 Учтите, в методы получения списков зарплат могут передаваться значения count,
 превышающие количество сотрудников в компании, или отрицательные.
 */