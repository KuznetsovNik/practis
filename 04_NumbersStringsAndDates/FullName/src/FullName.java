import java.util.Scanner;

public class FullName {
    /**
     * Написать программу, которая на входе через консоль принимает ФИО одной строкой
     * (например, “Иванов Сергей Петрович”) и выводит ФИО отдельно в следующем формате:
     *     Фамилия: Иванов
     *     Имя: Сергей
     *     Отчество: Петрович
     * Программу разделения строки на ФИО сделать устойчивой к неверным форматам ввода.
     **/
    public static void main(String[] args) {
        System.out.println("Введите ФИО");
        Scanner scanner = new Scanner(System.in);
        String fullName = scanner.nextLine();
        int space = fullName.indexOf(' ');
        int lastSpace = fullName.lastIndexOf(' ');
        System.out.println("\tФамилия: " + fullName.substring(0,space));
        System.out.println("\tИмя: " + fullName.substring(space,lastSpace));
        System.out.println("\tОтчество: " + fullName.substring(lastSpace,fullName.length()));
    }
}
