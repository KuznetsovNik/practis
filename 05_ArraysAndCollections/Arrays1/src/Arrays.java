public class Arrays {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] arrays = text.split(",?\\s+");

        int index = 1;
        for (int i = 0; i < arrays.length; i++){
            System.out.printf("replace array[%d] = array[%d]%n", i, arrays.length - index);
            arrays[i] = arrays[arrays.length - index];
            index++;

             for (int d = 0; d < arrays.length; d++){
                System.out.printf("%d: %s%n", d, arrays[d]);
            }
        }
        /** Не могу убрать баг
         * Длина массива =  7
         * Каждый-0 охотник-1 желает-2 знать-3 где-4 сидит-5 фазан-6
         * Вход в цикл замены местамии
         * arrays[0] = arrays[7 - 1] (фазан)
         * arrays[1] = arrays[7 - 2] (сидит)
         * arrays[2] = arrays[7 - 3] (где)
         * arrays[3] = arrays[7 - 4] (знать)
         * arrays[4] = arrays[7 - 5] (где) !Вот баг! Данный индекс массива уже инициализирован в цикле как где
         * И все последующие индексы также инициализированы
         * Выполнить условие не выходит
         * Не могу понять как исправить баг, пробовал по разному не выходит.
         */
    }
}
