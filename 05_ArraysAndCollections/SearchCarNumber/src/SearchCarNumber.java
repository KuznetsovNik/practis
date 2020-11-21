import java.util.*;

public class SearchCarNumber {
    public static void main(String[] args) {
        ArrayList<String> carsList = new ArrayList<>();

        // Метод генерации автомобильных номеров
        String[] characters = new String[]{"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У"};
        int o = 0;
        for (int i = 1; i < 198; i++) {
            for (int j = 1; j < 1000; j++) {
                String chars = characters[(int) (Math.random() * 10)];
                if (j < 10 && i < 10) {
                    String number = String.format("%s%d%d%d%s%s%d%d", chars, o, o, j, chars, chars, o, i);
                    carsList.add(number);
                    continue;
                } else if (j < 10 && i > 9) {
                    String number = String.format("%s%d%d%d%s%s%d", chars, o, o, j, chars, chars, i);
                    carsList.add(number);
                    continue;
                } else if (j > 99 && i < 10) {
                    String number = String.format("%s%d%s%s%d%d", chars, j, chars, chars, o, i);
                    carsList.add(number);
                    continue;
                } else if (j < 100 && i < 10) {
                    String number = String.format("%s%d%d%s%s%d%d", chars, o, j, chars, chars, o, i);
                    carsList.add(number);
                    continue;
                } else if (j < 100) {
                    String number = String.format("%s%d%d%s%s%d", chars, o, j, chars, chars, i);
                    carsList.add(number);
                    continue;
                }
                String number = String.format("%s%d%s%s%d", chars, j, chars, chars, i);
                carsList.add(number);
            }
        }
        // Метод печати полного списка номеров
        for(String list : carsList ){
            System.out.println(list);
        }
        Scanner scanner = new Scanner(System.in);
        String luckyNumber = scanner.nextLine();

        // Поиск перебором (2.12969E7 - время в среднем н/с)
        /*double a = System.nanoTime();
        System.out.print("Поиск перебором: Номер найден? " + carsList.contains(luckyNumber));
        double b = System.nanoTime();
        double с = b - a;
        System.out.println(" Время поиска:" + с + "н/с");*/

        // Бинарный поиск (1.30822E7 - время в среднем н/с)
        /*Collections.sort(carsList);
        double a = System.nanoTime();
        int index = Collections.binarySearch(carsList , luckyNumber);
        System.out.print("Бинарный поиск: Номер найден? " + index);
        double b = System.nanoTime();
        double с = b - a;
        System.out.println(" Время поиска:" + с + "н/с");*/

        // Поиск в HashSet (1.12086E7 - время в среднем н/с)
        /*HashSet<String> copyCarList = new HashSet<>();
        copyCarList.addAll(carsList);
        double a = System.nanoTime();
        System.out.print("Поиск в HashSet: Номер найден? " + copyCarList.contains(luckyNumber));
        double b = System.nanoTime();
        double c = b - a;
        System.out.println(" Время поиска:" + c + "н/с");*/

        // Поиск в TreeSet (1.1184E7 - время в среднем н/с)
        TreeSet<String> copyCarList = new TreeSet<>();
        copyCarList.addAll(carsList);
        double a = System.nanoTime();
        System.out.print("Поиск в TreeSet: Номер найден? " + copyCarList.contains(luckyNumber));
        double b = System.nanoTime();
        double c = b - a;
        System.out.println(" Время поиска:" + c + "н/с");

        /**
         * В поисках по каждому из методов, я искал одинаковый элемент в списках номеров.
         * Это был номер Х333ХХ92 , у него менялись только буквы.
         *
         * Вывод:
         * Поиск перебором самый медленный, так как он идет по каждому элементу отдельно.
         * Поиск бинарным методом быстрее поиска перебором, но приходится предварительно сортировать список
         * Поиск по ХэшСетом и ТриСетом примерно равны по времени, разница в том, что ХэшСет ищет по уникальному хэшу элемента, а
         * ТриСет изначально сортирует сам себя и потом ищет.
         *
         * На мой взгляд HashSet более универсальный.
         */
    }
}
