public class Container
{
     /** Схема
      * В метод поступает (число)
      * Число преобразовать в строку
      * Разложить это строку на индексы (инд0=ч ; инд1=и ; инд2=с ; инд3=л ; инд4=о)
      * Каждый индекс преобразовать в строку, а затем строку в число
      * Сложить эти индексы-строки арифметически
      * Возратить сумму
      *
      * Методы:
      * .toString() - преобразовывает число в строку
      * .length() - считает длину строки
      * .charAt(i) - разбивает строку на символы по индексам
      * .parseInt - преобразовывает строку в число
      * .valueOf - преобразовывает любой объект в строку
     **/
    public int count;

    public Integer sumDigits(Integer number) {
        int amount = 0;
        String integerString = number.toString();
        for (int i = 0; i < integerString.length(); i++){
            char charAt = integerString.charAt(i);
            System.out.printf("Символ номер %d в строке '%s' = %c%n", i, integerString, charAt);
            Integer index = Integer.parseInt(String.valueOf(charAt));
            amount += index;
        }
        System.out.print("Cумма всех чисел = ");
         return amount;
    }
}