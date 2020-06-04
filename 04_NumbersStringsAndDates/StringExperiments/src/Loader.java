
/**
 * Написать программу, которая на входе через консоль принимает фамилию, имя и отчество
 *  одной строкой (например, “Иванов Сергей Петрович”) и выводит фамилию, имя и отчество
 *  отдельно в следующем формате:
 *     Фамилия: Иванов
 *     Имя: Сергей
 *     Отчество: Петрович
 * Программу разделения строки на фамилию, имя и отчество сделать устойчивой к неверным форматам ввода.
**/
public class Loader {
    public static void main(String[] args) {
         char a = 'A';
         char b = 'B';
         char c = 'C';
         char d = 'D';
         char e = 'E';
         char f = 'F';
         char g = 'G';
         char h = 'H';
         char i = 'I';
         char j = 'J';
         char k = 'K';
         char l = 'L';
         char m = 'M';
         char n = 'N';
         char o = 'O';
         char p = 'P';
         char q = 'Q';
         char r = 'R';
         char s = 'S';
         char t = 'T';
         char u = 'U';
         char v = 'V';
         char w = 'W';
         char x = 'X';
         char y = 'Y';
         char z = 'Z';
         System.out.print("A-" + (int) a + " B-" + (int) b + " C-" + (int) c + " D-" + (int) d);
         System.out.print(" E-" + (int) e + " F-" + (int) f + " G-" + (int) g + " H-" + (int) h);
         System.out.print(" I-" + (int) i + " J-" + (int) j + " K-" + (int) k + " L-" + (int) l);
         System.out.print(" M-" + (int) m + " N-" + (int) n + " O-" + (int) o + " P-" + (int) p);
         System.out.print(" Q-" + (int) q + " R-" + (int) r + " S-" + (int) s + " T-" + (int) t);
         System.out.print(" U-" + (int) u + " V-" + (int) v + " W-" + (int) w + " X-" + (int) x);
         System.out.println(" Y-" + (int) y + " Z-" + (int) z + "\n");


         String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
         System.out.println(text);
         int salary1 = Integer.parseInt(text.substring(15,19));
         int salary2 = Integer.parseInt(text.substring(35,39));
         int salary3 = Integer.parseInt(text.substring(56,61));
         System.out.print("Сумма их зарплат: " );
         System.out.println(salary1 + salary2 + salary3);
    }

}