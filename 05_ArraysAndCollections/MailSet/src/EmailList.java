import java.util.TreeSet;

public class EmailList {
    TreeSet<String> mailSet = new TreeSet<>();

    public void list(){  // Метод печать email
        for (String list : mailSet){
            System.out.println(list);
        }
    }

    public String add(String name){ // Метод добавления
        mailSet.add(name);
        String done = "Адрес добавлен";
        return done;
    }
}
