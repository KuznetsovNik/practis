import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            String mail = scanner.nextLine();

            Matcher matcherAdd = Pattern.compile("^(?i)add (?<email>.+)").matcher(mail);
            if (matcherAdd.matches()) {
                String email = matcherAdd.group("email");
                Matcher matcherAddCorrect = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}").matcher(email);
                if (matcherAddCorrect.matches()) {
                    emailList.add(email);
                } else {
                    System.out.println("Неверный адрес");
                }
            }

            Matcher matcherList = Pattern.compile("^(?i)list").matcher(mail);
            if (matcherList.matches()) {
                emailList.list();
            }
        }
    }
}