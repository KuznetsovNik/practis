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
        String[] name = fullName.split(" ");
        for (int i = 0; i < name.length; i++){
        }
        if (name.length != 3){
            System.out.println("Некоректный ввод");
        }else {
            System.out.println("\tФамилия: " + name[0]);
            System.out.println("\tИмя: " + name[1]);
            System.out.println("\tОтчество: " + name[2]);
        }
        /**
        int space = fullName.indexOf(' ');
        int lastSpace = fullName.lastIndexOf(' ');
        int haveTwoSpace = fullName.indexOf(' ', space + 1);
        if ( space != -1 && haveTwoSpace != -1) {
            System.out.println("\tФамилия: " + fullName.substring(0, space));
            System.out.println("\tИмя: " + fullName.substring(space,lastSpace));
            System.out.println("\tОтчество: " + fullName.substring(lastSpace,fullName.length()));
        } else {
            System.out.println("Введи полностью ФИО");
        }
         **/
    }
}
