import java.util.Scanner;

public class MailSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            String mail = scanner.nextLine();
            if (mail.toLowerCase().startsWith("list")) {
                emailList.list();
            }else {
                emailList.add(mail);
            }
        }
    }
}