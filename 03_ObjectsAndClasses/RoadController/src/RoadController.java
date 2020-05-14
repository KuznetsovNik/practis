import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    //Переменная  типа double
    private static double passengerCarMaxWeight = 3500.0; // kg
    //Переменная  типa int
    private static int passengerCarMaxHeight = 2000; // mm
    //Переменная  типa int
    private static int controllerMaxHeight = 3500; // mm

    //Переменная  типa int
    private static int passengerCarPrice = 100; // RUB
    //Переменная  типa int
    private static int cargoCarPrice = 250; // RUB
    //Переменная  типa int
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);
        //Переменная  типа int
        int carsCount = scanner.nextInt();

        //Переменная  типа int
        for(int i = 0; i < carsCount; i++) {
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            //Переменная типа int
            int price = calculatePrice(car);
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        //Переменная типа int
        int carHeight = car.height;
        //Переменная типа double
        double carWeight = car.weight;
        //Переменная типа int
        int price = 0;
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        //Грузовой автомобиль
        else if (carHeight > passengerCarMaxHeight || carWeight > passengerCarMaxWeight) {
            price = cargoCarPrice;
            if (car.hasVehicle) {
                price = price + vehicleAdditionalPrice;
            }
        }

        //Легковой автомобиль
        else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}