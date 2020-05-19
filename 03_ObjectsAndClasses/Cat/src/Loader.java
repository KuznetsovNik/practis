
public class Loader                                          // Класс Loader
{
    private static Cat getKitten() {                         // Геттер Создания Котёнка
        Cat kitten = new Cat(1100.00);                 // Генерация котёнка по конструктору
        return kitten;
    }

    public static void main(String[] args) {                       // Метод main
        Cat vasya = new Cat();                                     // Первый кот
        System.out.println("Vasya weight:" + vasya.getWeight());
        vasya.feed(200.5);
        vasya.pee();                                              // Исспользование Метода Туалет
        vasya.pee();
        vasya.pee();
        System.out.println("Vasya weight:" + vasya.getWeight());
        System.out.println();

        Cat toma = new Cat();                                     // Второй кот
        System.out.println("Toma weight:" + toma.getWeight());
        toma.feed(350.7);
        toma.feed(10.6);
        System.out.println("Toma weight:" + toma.getWeight());
        System.out.println("Toma was eat: "+ toma.getFeedFood() + "gm of food"); // Использование Метода Сумма съеденной еды
        System.out.println();

        Cat kyzya = new Cat();                                    // Третий кот
        System.out.println("Kyzya weight:" + kyzya.getWeight());
        kyzya.drink(330.30);
        System.out.println("Kyzya weight:" + kyzya.getWeight());
        System.out.println("Kyzya is " + kyzya.getStatus());
        System.out.println();

        Cat masha = new Cat();                                     // Четвертый кот
        System.out.println("Masha weight:" + masha.getWeight());
        for (;masha.getWeight() < 9000;) {                         // Цикл Перекормить кошку
            masha.feed(1.5);
        }
        System.out.println("Masha is " + masha.getStatus());
        System.out.println();

        Cat monika = new Cat();                                       // Пятый кот
        System.out.println("Monika weight:" + monika.getWeight());
        while (monika.getWeight() > 0) {                              // Оператор Замяукать кошку
            monika.meow();
        }
        System.out.println("Monika is " + monika.getStatus());
        System.out.println();

        Cat mike = new Cat(8500.00);                           //  Шестой кот
        System.out.println("Mike weight:" + mike.getWeight());
        mike.setColorsCats(ColorsCats.BLACK_CAT);
        System.out.println(mike.getColors());
        System.out.println();

        Cat barsik = getKitten();                                            // Седьмой кот - котёнок
        System.out.println("Kitten Barsik weight:" + barsik.getWeight());
        System.out.println();

        Cat filimon = new Cat(5000.00);                                // Восьмой кот
        filimon.feed(250.00);
        System.out.println("Filimon weight:" + filimon.getWeight());
        System.out.println();

        Cat djesika = new Cat (filimon);                                     // Девятый кот - клон
        System.out.println("Djesika weight:" + djesika.getWeight());
        djesika.feed(1500.00);
        System.out.println("Djesika was eat: "+ djesika.getFeedFood() + "gm of food");
        System.out.println();

        Cat barbara =  new Cat(12000);                                // Создание кошки с превышенным весом

        System.out.println("How many cats: "+ Cat.getCount());               // Использованиие Метода Общее число кошек

    }
}