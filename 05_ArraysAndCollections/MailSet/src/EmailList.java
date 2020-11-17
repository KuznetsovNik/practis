import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    TreeSet<String> mailSet = new TreeSet<>();

    public void list(){  // Метод печать email
        for (String list : mailSet){
            System.out.println(list);
        }
    }

    public String add(String name){ // Метод добавления
        Matcher matcherAdd = Pattern.compile("^(?i)add (?<email>.+)").matcher(name);
        if (matcherAdd.matches()) {
            String email = matcherAdd.group("email");
            Matcher matcherAddCorrect = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}").matcher(email);
            if (matcherAddCorrect.matches()) {
                mailSet.add(name);
            } else {
                System.out.println("Неверный адрес");
            }
        }
        String done = "Адрес добавлен";
        return done;
    }
}
