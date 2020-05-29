import java.lang.ref.SoftReference;

public class Main
{
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        System.out.println(container.sumDigits(2478));
        System.out.println();
        int sum = container.getAmount();
        System.out.println("Cумма всех чисел = " + sum);
    }
}


