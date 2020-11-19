import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapBook {
    public static void main(String[] args) {
        TreeMap<String , Integer> name2number = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            String contact = scanner.nextLine();

            // Команда на печать контаков
            Matcher matcherList = Pattern.compile("^(?i)list").matcher(contact);
            if (matcherList.matches()) {
                for (String key : name2number.keySet()) {
                    System.out.println(key + " - " + name2number.get(key));
                }
                continue;
            }

            // Команда добавления контакта
            Matcher matcherAddAll = Pattern.compile("(?<number>\\d+) (?<person>.+)").matcher(contact);
            Matcher matcherAddNumber = Pattern.compile("(?<number>\\d+)").matcher(contact);
            if (matcherAddAll.matches()) {
                name2number.put(matcherAddAll.group("person"), Integer.parseInt(matcherAddAll.group("number")));
            } else if (matcherAddNumber.matches()) {
                // Проверка на существование номера
                if (name2number.containsValue(Integer.parseInt(contact))) {
                    System.out.println(contact + " - " + name2number.keySet());
                    continue;
                }
                // Просьба дополнить контакт
                System.out.println("Напишите Имя абонента");
                String name = scanner.nextLine();
                name2number.put(name,Integer.parseInt(matcherAddNumber.group("number")));
            } else {
                // Проверка на существование имени
                if (name2number.containsKey(contact)) {
                    System.out.println(contact + " - " + name2number.values());
                    continue;
                }
                // Просьба дополнить контакт
                System.out.println("Напишите номер абонента");
                String phone = scanner.nextLine();
                name2number.put(matcherAddAll.group("person"),Integer.parseInt(phone));
            }
        }
    }
}
