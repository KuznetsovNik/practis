
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
        if (weight > MAX_WEIGHT){
            System.out.println("Too much weight, the cat is dead:(");
            countCats--;
        }
        countCats++;
    }

    public Cat(Cat clone){                                       // Конструктор Cat
        this.weight = clone.weight;
        this.originWeight = clone.weight;
        countCats++;
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

    public void meow() {                                       // Метод Мяу
        boolean isAlive = MIN_WEIGHT < weight && weight < MAX_WEIGHT;
        weight = weight - 1;
        System.out.println("Meow");
        if ( isAlive == true && MAX_WEIGHT < weight ) {
            countCats--;
        } else if ( isAlive == true && weight < MIN_WEIGHT){
            countCats--;
        }
    }

    public void pee() {                                        // Метод Туалет
        boolean isAlive = MIN_WEIGHT < weight && weight < MAX_WEIGHT;
        weight = weight - 100;
        System.out.println("Poop");
        if ( isAlive == true && MAX_WEIGHT < weight || weight < MIN_WEIGHT) {
            countCats--;
        } else if ( isAlive == true && weight < MIN_WEIGHT){
            countCats--;
        }
    }

    public void feed(Double amount) {                          // Метод Покормить
        boolean isAlive = MIN_WEIGHT < weight && weight < MAX_WEIGHT;
        weight = weight + amount;
        this.allFood = allFood + amount;
        if ( isAlive == true && MAX_WEIGHT < weight || weight < MIN_WEIGHT) {
            countCats--;
        } else if ( isAlive == true && weight < MIN_WEIGHT){
            countCats--;
        }
    }

    public void drink(Double amount) {                         // Метод Попить
        boolean isAlive = MIN_WEIGHT < weight && weight < MAX_WEIGHT;
        weight = weight + amount;
        if ( isAlive == true && MAX_WEIGHT < weight || weight < MIN_WEIGHT) {
            countCats--;
        } else if ( isAlive == true && weight < MIN_WEIGHT){
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