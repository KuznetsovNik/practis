import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);
        int sum = 0;

        Pattern pattern = Pattern.compile("(?<groupA>\\d+)");
        Matcher match = pattern.matcher(text);
        while (match.find()){
            sum += Integer.parseInt(match.group("groupA"));
        }
        System.out.println("Сумма всех зарплат - " + sum);



        /**
        String[] sentences =  text.split("руб");
        int allSalary = 0;
        for (int i = 0; i < sentences.length; i++){
            if (sentences[i].replaceAll("\\D", " ").trim().isEmpty()){
                continue;
            }
            int salary = Integer.parseInt(sentences[i].replaceAll("\\D"," ").trim());
            allSalary += salary;
        }
        System.out.println("Сумма всех зарплат = " + allSalary);
         **/
    }
}