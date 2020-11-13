import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mail = scanner.nextLine();
        TreeSet<String> mailSet = new TreeSet<>();

        // Команда добавления email и проверка корректности
        Matcher matcherAdd = Pattern.compile("^(?i)add (?<email>.+)").matcher(mail);
        if (matcherAdd.matches()){
            String email = mail.replaceAll("^(?i)add","");
            Matcher matcherAddCorrect = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}").matcher(email);
            if (matcherAddCorrect.matches()) {
                mailSet.add(matcherAdd.group("email"));
            }else {
                System.out.println("Неверный адрес");
            }
        }

        // Команда печать email
        Matcher matcherList = Pattern.compile("^(?i)list").matcher(mail);
        if (matcherList.matches()){
            for (String list : mailSet){
                System.out.println(list);
            }
        }
    }
}