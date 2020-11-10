
public class ProjectX {

    public static final int SIZE_ARRAYS = 7;  // Константа на размер креста

    public static void main(String[] args) {
        int finalSize = SIZE_ARRAYS; // Инкапсуляция константы
        String [][] projectX = new String[finalSize][finalSize]; // Создаём массив массивов строк с именем projectX
        int index = 1; // Переменная для создания второй диагонали перекрестия
        for (int i = 0; i < projectX.length ; i++) { // Перебераем колличество массивов
            for (int j = 0; j < projectX.length; j++) { // Перебераем и присваиваем строки в массивах
                if (i == j || j == projectX.length - index) {
                    projectX[i][j] = "x";
                } else {
                    projectX[i][j] = " ";
                }
            }
            index++;
        }
        for (int x = 0; x < projectX.length; x++) { // Цикл для печати креста
            System.out.println();
            for (int y = 0; y < projectX[x].length; y++) {
                System.out.print("\t" + projectX[x][y]);
            }
        }
    }
}

