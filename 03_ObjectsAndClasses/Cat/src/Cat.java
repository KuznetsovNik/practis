
public class Cat                                                // Класс Cat
{
    private static final int EYES_AMOUNT = 4;                   // Переменные класса Cat
    private double originWeight;
    private double weight;
    private static final double minWeight = 1000.0;
    private static final double maxWeight = 9000.0;
    private double allFood;
    private static int countCats = 0;
    public ColorsCats colors;


    public Cat()                                               // Конструктор Cat
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        countCats++;
    }

    public Cat(double  weight)                                // Конструктор Cat
    {
        this();
        this.weight = weight;
    }

    public void setColorsCats(ColorsCats colors){              // Сеттер для цвета кошки
        this.colors = colors;
    }
    public ColorsCats getColors(){                             // Геттер для цвета кошки
        return colors;
    }

    public void meow()                                         // Метод Мяу
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void pee()                                         // Метод Туалет
    {
        weight = weight - 100;
        System.out.println("Poop");
    }

    public void feed(Double amount)                            // Метод Покормить
    {
        weight = weight + amount;
        allFood = amount;
    }

    public void drink(Double amount)                            // Метод Попить
    {
        weight = weight + amount;
    }

    public static int getCount()                               // Геттер Общее число кошек
    {
        return countCats;
    }

    public double getFeedFood()                               // Геттер Сумма съеденной еды
    {
        return allFood;
    }

    public double getWeight()                                  // Геттер Веса
    {
        return weight;
    }

    public String getStatus()                              // Геттер Статуса Кошки
    {
        if(weight < minWeight)
        {
            countCats--;
            return "Dead";
        }
        else if(weight > maxWeight)
        {
            countCats--;
            return "Exploded";
        }
        else if(weight > originWeight)
        {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}