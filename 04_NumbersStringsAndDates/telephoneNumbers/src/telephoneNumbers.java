import java.util.Scanner;

public class telephoneNumbers {
    public static void main(String[] args) {
        System.out.println("Введи номер телефона");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        System.out.println(number.replaceAll("[^0-9]",""));
    }
}
