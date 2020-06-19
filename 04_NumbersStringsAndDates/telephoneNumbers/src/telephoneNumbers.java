import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class telephoneNumbers {
    public static void main(String[] args) {
        System.out.println("Введи номер телефона");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String pattern = number.replaceAll("[^\\d]","" );
        if (pattern.length() == 11) {
            System.out.println(pattern.replaceAll("^8(.{10})$", "7$1"));
        }else if (pattern.length() == 10){
           System.out.println("7" + pattern);
        } else {
            System.out.println("Неверный формат номера");
        }
    }
}
