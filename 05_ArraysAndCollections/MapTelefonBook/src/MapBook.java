import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapBook {
    public static void main(String[] args) {
        TreeMap<String , Long > name2number = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            String contact = scanner.nextLine();

            // Команда на печать контаков
            Matcher matcherList = Pattern.compile("^(?i)list").matcher(contact);
            if (matcherList.matches()) {
                for (Map.Entry<String , Long> entry : name2number.entrySet()){
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
                continue;
            }

            // Команда добавления контакта
            Matcher matcherAddAll = Pattern.compile("(?<number>\\d+) (?<person>.+)").matcher(contact);
            Matcher matcherAddNumber = Pattern.compile("(?<number>\\d+)").matcher(contact);
            Matcher matcherAddPerson = Pattern.compile("(?<person>.+)").matcher(contact);
            if (matcherAddAll.matches()) {
                name2number.put(matcherAddAll.group("person") , Long.parseLong(matcherAddAll.group("number")) );
            } else if (matcherAddNumber.matches()) {
                // Проверка на существование номера
                if (name2number.containsValue(Long.parseLong(contact))) {
                    System.out.println(name2number.get(contact) + " - " + contact);
                    continue;
                }
                // Просьба дополнить контакт
                System.out.println("Напишите Имя абонента");
                String name = scanner.nextLine();
                name2number.put(name , Long.parseLong(matcherAddNumber.group("number")));
            } else if (matcherAddPerson.matches()){
                // Проверка на существование имени
                if (name2number.containsKey(contact)) {
                    System.out.println(name2number.get(contact) + " - " + contact);
                    continue;
                }
                // Просьба дополнить контакт
                System.out.println("Напишите номер абонента");
                String phone = scanner.nextLine();
                name2number.put(matcherAddPerson.group("person") , Long.parseLong(phone));

            }
        }
    }
}
