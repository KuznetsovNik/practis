public class Main {
    private static final String DATA_FILE = ("C:/Users/Admin/Desktop/movementList.csv");
    public static void main(String[] args) {
        Movements alfaBank = new Movements(DATA_FILE);
        System.out.println("Сумма расходов: " + alfaBank.getExpenseSum() + " руб.");
        System.out.println("Сумма доходов: " + alfaBank.getIncomeSum() + " руб.");
        alfaBank.getExpenditure();
        /**
         * Примеры работы программы
         *
         * Сумма расходов: 398 563.39 руб.
         * Сумма доходов: 289 890.06 руб.
         *
         * Суммы расходов по организациям:
         * RUSMOSKVA56  SHLOVE REPUBLIC        1 081.53 руб.
         * RUSMOSCOW42 SHCL ETOILE                     126.34 руб.
         * RUSPUSHKINO105ZOOMAGAZIN 4             217.65 руб.
         */
    }
}
