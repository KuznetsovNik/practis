public class Arrays {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";  // Строка text с изначальной фразой
        System.out.println(text);   // Печать text
        String[] arrays = text.split(",?\\s+"); // Создание массива строк, разбитием регулярным выражением

        int index = 1; // Переменная для отступания с конца строки
        String tmp; // Временная строка для замены местами начала и конца

        for (int i = 0; i < arrays.length/2 ; i++) { // Цикл для замены мест, делим на 2 длинну для опеределения середины
            tmp = arrays[i];  //
            arrays[i] = arrays[arrays.length - index];
            arrays[arrays.length - index] = tmp;
            index++;
        }

        for (int i = 0; i < arrays.length; i++){  // Печать
            System.out.print(arrays[i] + " ");
        }
    }
}
