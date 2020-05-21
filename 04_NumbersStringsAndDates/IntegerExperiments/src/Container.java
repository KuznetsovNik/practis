public class Container
{
    public int count;

    /** Добиться чтобы это метод считал сумму вводных данных
     *  Например если внутри параметра метода поставить 575
     * Он будет печатать в консоле 17
     * */
    public Integer sumDigits(Integer number) {
        String integerString = number.toString();
        Character character0 = integerString.charAt(0);
        Character character1 = integerString.charAt(1);
        Character character2 = integerString.charAt(2);
        Character character3 = integerString.charAt(3);
        Character character4 = integerString.charAt(4);
        Integer index0 = Integer.parseInt(String.valueOf(character0));
        Integer index1 = Integer.parseInt(String.valueOf(character1));
        Integer index2 = Integer.parseInt(String.valueOf(character2));
        Integer index3 = Integer.parseInt(String.valueOf(character3));
        Integer index4 = Integer.parseInt(String.valueOf(character4));
        int amount = index0 + index1 + index2 + index3 + index4;
        return amount;
        /** Схема
         * В метод поступает (число)
         * Число преобразовать в строку
         * Разложить это строку на индексы (инд0=ч ; инд1=и ; инд2=с ; инд3=л ; инд4=о)
         * Каждый индекс преобразовать в строку, а затем строку в число
         * Сложить эти индексы-строки арифметически
         * Возратить сумму
         */
    }
}