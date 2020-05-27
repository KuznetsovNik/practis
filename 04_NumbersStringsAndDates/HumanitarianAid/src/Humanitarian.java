import java.util.Scanner;

/**
 * В каждый грузовик влезает максимум 12 контейнеров.
 * В каждый контейнер - не более 27 ящиков.
 * Ящики, контейнеры и грузовики пронумерованы.
 * Напишите программу, которая будет распределять ящики
 * по контейнерам и грузовикам в зависимости от их количества,
 * а также напечатает, сколько всего нужно грузовиков и контейнеров.
 * На вход программы через консоль должно подаваться число ящиков.
 * На выходе результат должен выглядеть следующим образом:
 *     Грузовик 1:
 *         Контейнер 1:
 *             Ящик 1
 *             Ящик 2
 *             Ящик 3
 *             …
 *         Контейнер 2
 *             Ящик 28
 *             Ящик 29
 *
 *          Схема:
 *          * Вводим в консоль общее число ящиков
 *          * Дальше дробим общее число ящиков на максимальную вместимость грузовика в ящиках # 35
 *          * Выходит количество грузовиков:там уже считаем ящики и контейнеры внутри грузовиков
 *          * Паралельно всё это печатаем
 *          * В конце выводим общее количество всего
**/

public class Humanitarian {
    public static int truckCapacity =  0;                  // Переменная вместимость грузовика = 0 конейтнеров
    public static final int MAX_TRUCK_CAPACITY = 12;       // Переменная макс вместимость грузовика = 12 контейнеров
    public static int containerCapacity = 0;               // Переменная вместимость контейнера = 0 ящиков
    public static final int MAX_CONTAINER_CAPACITY = 27;   // Переменная макс вместимость контейнера = 27 ящиков

    public static void main(String[] args) {
        System.out.println("Сколько ящиков отгрузить?");
        Scanner scanner = new Scanner(System.in);         // Ввод в косноль число ящиков
        int boxes = scanner.nextInt();                   // Инициализация перменнной ящики из косноли

        int maxTruckBoxesCapacity = MAX_CONTAINER_CAPACITY * MAX_TRUCK_CAPACITY;
        int howManyTruck = Math.round(boxes / maxTruckBoxesCapacity);
        if (howManyTruck == 0){
            howManyTruck++;
            System.out.println("Грузовик " + howManyTruck + ":");
            int howManyContainer = Math.round(boxes / MAX_CONTAINER_CAPACITY); // Может быть нужно назвать её truckCapacity
            for (truckCapacity = 0; truckCapacity <= howManyContainer ; truckCapacity++){
                    containerCapacity++;
                    System.out.println("Контейнер " + containerCapacity);
                    for (int i = 0; i <= MAX_CONTAINER_CAPACITY; i++){
                        System.out.println("Ящик " + i);
                    }
            }
        }
        System.out.println("Количество грузовиков - " + howManyTruck);
        System.out.println("Количество контейнеров - " + containerCapacity);
    }
}
