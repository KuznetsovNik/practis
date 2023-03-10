
public class Cat {                                              // Класс Cat
    private static final int EYES_AMOUNT = 4;                   // Переменные класса Cat
    private double originWeight;
    private double weight;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;
    private double allFood;
    private static int countCats;
    public ColorsCats colors;

    public Cat() {                                              // Конструктор Cat
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(double  weight) {                               // Конструктор Cat
        this.weight = weight;
        this.originWeight = weight;
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            System.out.println("Incorrect weight, the cat is dead:(");
            countCats--;
        }
        countCats++;
    }

    public Cat(Cat clone){                                       // Конструктор Cat
        this (1500.0 + 3000.0 * Math.random());
        this.weight = clone.weight;
        this.originWeight = clone.weight;
        this.allFood = clone.allFood;
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            System.out.println("Incorrect weight, the cat is dead:(");
            countCats--;
        }
    }

    public Cat copy() {                                         // Метод Клонирования
        return new Cat(this);
    }

    public void setColorsCats(ColorsCats colors){              // Сеттер для цвета кошки
        this.colors = colors;
    }
    public ColorsCats getColors(){                             // Геттер для цвета кошки
        return colors;
    }

    boolean isAlive() {                                       // Метод Кот жив?
        return MIN_WEIGHT < weight && weight < MAX_WEIGHT;
    }

    public void meow() {                                       // Метод Мяу
        boolean wasAlive = isAlive();
        weight = weight - 1;
        System.out.println("Meow");
        if ( wasAlive == true && isAlive() == false) {
            countCats--;
        }
    }

    public void pee() {                                        // Метод Туалет
        boolean wasAlive = isAlive();
        weight = weight - 100;
        System.out.println("Poop");
        if ( wasAlive == true && isAlive() == false) {
            countCats--;
        }
    }

    public void feed(Double amount) {                          // Метод Покормить
        boolean wasAlive = isAlive();
        weight += amount;
        this.allFood = allFood + amount;
        if ( wasAlive == true && isAlive() == false) {
            countCats--;
        }
    }

    public void drink(Double amount) {                         // Метод Попить
        boolean wasAlive = isAlive();
        weight += amount;
        if ( wasAlive == true && isAlive() == false) {
            countCats--;
        }
    }

    public static int getCount() {                             // Геттер Общее число кошек
        return countCats;
    }

    public double getFeedFood() {                              // Геттер Сумма съеденной еды
        return allFood;
    }

    public double getWeight() {                               // Геттер Веса
        return weight;
    }

    public String getStatus() {                               // Геттер Статуса Кошки
        if(weight < MIN_WEIGHT) {
            return "Dead";

        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}