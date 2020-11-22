import java.util.*;

public class SearchCarNumber {
    public static void main(String[] args) {
        ArrayList<String> carsList = new ArrayList<>();

        // Метод генерации автомобильных номеров
        String[] characters = new String[]{"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У"};
        for (int i = 0; i < characters.length; i++){
            for (int j = 1; j < 10; j++){
                for ( int r = 1; r < 198; r++){
                    String chars = characters[i];
                    String region = String.valueOf(r);
                    if (r < 10){
                        region = "0" + region;
                    }
                    String number = String.format("%s%d%d%d%s%s%s", chars, j, j, j, chars, chars, region);
                    carsList.add(number);


                }
            }
        }
        for(String list : carsList ){
            System.out.println(list);
        }
        Scanner scanner = new Scanner(System.in);
        String luckyNumber = scanner.nextLine();

        // Поиск перебором
          long beforeSearchLine = System.nanoTime();
          System.out.print("Поиск перебором: Номер найден? " + carsList.contains(luckyNumber));
          long afterSearchLine = System.nanoTime();
          long totalSearchLine = afterSearchLine - beforeSearchLine;
          System.out.println(" Время поиска:" + totalSearchLine + "н/с");


        //Бинарный поиск
        Collections.sort(carsList);
        long beforeSearchBinary = System.nanoTime();
        int index = Collections.binarySearch(carsList , luckyNumber);
        System.out.print("Бинарный поиск: Номер найден? ");
        System.out.print(index > 0);
        long afterSearchBinary = System.nanoTime();
        long totalSearchBinary = afterSearchBinary - beforeSearchBinary;
        System.out.println(" Время поиска:" + totalSearchBinary + "н/с");

        // Поиск в HashSet
        HashSet<String> copyCarListHash = new HashSet<>();
        copyCarListHash.addAll(carsList);
        long beforeSearchHash = System.nanoTime();
        System.out.print("Поиск в HashSet: Номер найден? " + copyCarListHash.contains(luckyNumber));
        long afterSearchHash = System.nanoTime();
        long totalSearchHash = afterSearchHash - beforeSearchHash;
        System.out.println(" Время поиска:" + totalSearchHash + "н/с");

        // Поиск в TreeSet
        TreeSet<String> copyCarListTree = new TreeSet<>();
        copyCarListTree.addAll(carsList);
        long beforeSearchTree = System.nanoTime();
        System.out.print("Поиск в TreeSet: Номер найден? " + copyCarListTree.contains(luckyNumber));
        long afterSearchTree = System.nanoTime();
        long totalSearchTree = afterSearchTree - beforeSearchTree;
        System.out.println(" Время поиска:" + totalSearchTree + "н/с");



        /**
         * В поисках по каждому из методов, я искал одинаковый элемент в списках номеров.
         * Это был номер А333АА92
         *
         * Вывод:
         * Бинарный поиск самый быстрый, он предварительно отсартирован,
         * его скорость от того что он делит всё на два и лишнее отбрасывает.
         *
         * Далее HashSet он ищет по уникальному хэшу внутри себя. И TreeSet он сортирует сам себя а потом ищет бинаром.
         * Они оба от случая к случаю опережают друг друга.
         *
         * Последний и самый долгий поиск перебором, он просто идёт по всему списку, чем больше список тем дольше поиск.
         */
    }
}
