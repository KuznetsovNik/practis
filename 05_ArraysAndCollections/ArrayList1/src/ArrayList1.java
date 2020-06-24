import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayList1 {
    public static void main(String[] args) {
        System.out.println("Здравствуйте, это список дел. Введите одну из команд:");
        System.out.println("LIST - список дел\nADD - добавить заметку\nEDIT - заменить\nDELETE - удалить");
        Scanner scanner = new Scanner(System.in);
        String toDo = scanner.nextLine();
        ArrayList<String> toDoList = new ArrayList<>();

        // Распечатка списка дел
        Pattern pattern = Pattern.compile("LIST|List|list");
        Matcher matcher = pattern.matcher(toDo);
        if (matcher.find()) {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.printf("%d %s\n", i ,toDoList.get(i));
            }
        }

        // Добавление заметки
        Pattern pattern1 = Pattern.compile("ADD|Add|add");
        Matcher matcher1 = pattern1.matcher(toDo);
        if (matcher1.find()){
            Pattern pattern2 = Pattern.compile("[^0-9]");
            Matcher matcher2 = pattern2.matcher(toDo);
            if (matcher2.find()) {
                if (toDo.replaceAll("[^0-9]","").trim().isEmpty()){
                    toDoList.add(toDo.replaceAll("ADD|Add|add",""));
                }else {
                    int number = Integer.parseInt(toDo.replaceAll("[^0-9]", ""));
                    if (number != toDoList.size()) {
                        number = toDoList.size();
                        toDoList.add(number, toDo.replaceAll("ADD|Add|add|[0-9]", ""));
                    }
                }
            }
        }

        // Замена заметки
        Pattern pattern3 = Pattern.compile("EDIT|Edit|edit");
        Matcher matcher3 = pattern3.matcher(toDo);
        if (matcher3.find()) {
            int where = Integer.parseInt(toDo.replaceAll("[^0-9]", ""));
            String text = toDo.replaceAll("EDIT|Edit|edit|[0-9]", "");
            toDoList.add(where,text);
            toDoList.remove(where + 1);
        }

        // Удаление
        Pattern pattern4 = Pattern.compile("DELETE|Delete|delete");
        Matcher matcher4 = pattern4.matcher(toDo);
        if (matcher4.find()){
            int index = Integer.parseInt(toDo.replaceAll("[^0-9]",""));
            toDoList.remove(index);
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
