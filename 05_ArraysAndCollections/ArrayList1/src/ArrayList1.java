import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayList1 {
        public static void main (String[]args) {
            System.out.println("Здравствуйте, это список дел. Введите одну из команд:");
            System.out.println("LIST - список дел\nADD - добавить заметку\nEDIT - заменить\nDELETE - удалить");
            Scanner scanner = new Scanner(System.in);
            String toDo = scanner.nextLine();
            ArrayList<String> toDoList = new ArrayList<>(); // Создаём список элементов

            // Команда печати списка дел
            Matcher matcherList = Pattern.compile("^(?i)list").matcher(toDo);
            if (matcherList.matches()) {
                for (int i = 0; i < toDoList.size(); i++) {
                    System.out.printf("%d %s\n", i, toDoList.get(i));
                }
            }

            // Команнда добавления заметки
            Matcher matcherAddIndexed = Pattern.compile("^(?i)add (?<NoDeal>\\d+) (?<text>.+)").matcher(toDo);
            Matcher matcherAdd = Pattern.compile("^(?i)add (?<text>.+)").matcher(toDo);
            if (matcherAddIndexed.matches()) {
                int number = Integer.parseInt(matcherAddIndexed.group("NoDeal"));
                if (number != toDoList.size()) {
                    number = toDoList.size();
                    toDoList.add(number, matcherAddIndexed.group("text"));
                }
            } else if (matcherAdd.matches()) {
                toDoList.add(matcherAdd.group("text"));
            }

            // Команда на замену заметки
            Matcher matcherEdit = Pattern.compile("^(?i)edit").matcher(toDo);
            if (matcherEdit.matches()) {
                int where = Integer.parseInt(toDo.replaceAll("[^\\d]", ""));
                String text = toDo.replaceAll("(?i)edit|\\d", "");
                toDoList.add(where, text);
                toDoList.remove(where + 1);
            }

            // Команда удаления заметки
            Matcher matcherDelete = Pattern.compile("^(?i)delete").matcher(toDo);
            if (matcherDelete.matches()) {
                int index = Integer.parseInt(toDo.replaceAll("[^\\d]", ""));
                if (index > toDoList.size()) {
                    toDoList.remove(toDoList.size() - 1);
                } else {
                    toDoList.remove(index);
                }
            }
        }
}
