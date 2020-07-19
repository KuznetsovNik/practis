import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayList1 {
        public static void main (String[]args){
        System.out.println("Здравствуйте, это список дел. Введите одну из команд:");
        System.out.println("LIST - список дел\nADD - добавить заметку\nEDIT - заменить\nDELETE - удалить");
            Scanner scanner = new Scanner(System.in);
            String toDo = scanner.nextLine();
            ArrayList<String> toDoList = new ArrayList<>();

            // Распечатка списка дел
            Pattern patternList = Pattern.compile("(?i)list");
            Matcher matcherList = patternList.matcher(toDo);
            if (matcherList.find()) {
                for (int i = 0; i < toDoList.size(); i++) {
                    System.out.printf("%d %s\n", i, toDoList.get(i));
                }
            }

            // Добавление заметки
            Pattern patternAdd = Pattern.compile("(?<Add>(?i)add)|\\d+");
            Matcher matcherAdd = patternAdd.matcher(toDo);
            if (matcherAdd.find()) {
                    if (toDo.replaceAll("[^\\d]", "").trim().isEmpty()) {
                        toDoList.add(toDo.replaceAll(matcherAdd.group("Add"), ""));
                    } else {
                        int number = Integer.parseInt(toDo.replaceAll("[^\\d]", ""));
                        if (number != toDoList.size()) {
                            number = toDoList.size();
                            toDoList.add(number, toDo.replaceAll("(?i)add|(\\d)*" , ""));
                        }
                    }
            }

            // Замена заметки
            Pattern patternEdit = Pattern.compile("(?i)edit");
            Matcher matcherEdit = patternEdit.matcher(toDo);
            if (matcherEdit.find()) {
                int where = Integer.parseInt(toDo.replaceAll("[^\\d]", ""));
                String text = toDo.replaceAll("(?i)edit|\\d", "");
                toDoList.add(where, text);
                toDoList.remove(where + 1);
            }

            // Удаление
            Pattern patternDelete = Pattern.compile("(?i)delete");
            Matcher matcherDelete = patternDelete.matcher(toDo);
            if (matcherDelete.find()) {
                int index = Integer.parseInt(toDo.replaceAll("[^\\d]", ""));
                if (index > toDoList.size()) {
                    toDoList.remove(toDoList.size() - 1);
                }else {
                    toDoList.remove(index);
                }
            }
            
        /**
         * Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
         *
         * Принцип работы команд:
         *
         * LIST — выводит дела с их порядковыми номерами;
         * ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
         * EDIT — заменяет дело с указанным номером;
         * DELETE — удаляет.
         * Примеры команд:
         *
         * LIST
         * ADD Какое-то дело
         * ADD 4 Какое-то дело на четвёртом месте
         * EDIT 3 Новое название дела
         * DELETE 7
         **/
    }
}
