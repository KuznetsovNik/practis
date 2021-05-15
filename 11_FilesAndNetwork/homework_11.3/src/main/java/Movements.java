import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Movements {
    private double allExpense;
    private double allIncome;
    ArrayList<Excerpt> excerptList = new ArrayList<>();

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                String[] fragments = line.split(",");
                if (fragments.length != 8) {
                    String fixedLine = line.replaceAll("\"(\\d+),(\\d+)\"", "$1.$2");
                    String[] fragments2 = fixedLine.split(",");
                    String description = fragments2[5].replaceAll("\\s{2,}|\\d{2,}|\\+|\\.|\\\\|\\/|\\)|\\(|\\-", "");
                    excerptList.add(new Excerpt(
                            description,
                            fragments2[6],
                            fragments2[7]));
                    if (fragments2.length != 8) {
                        System.out.println("!!!Ошибка!!!");
                    }
                    continue;
                }
                String description2 = fragments[5].replaceAll("\\s{2,}|\\d{2,}|\\+|\\.|\\\\|\\/|\\)|\\(|\\-", "");
                excerptList.add(new Excerpt(
                        description2,
                        fragments[6],
                        fragments[7]));
            }
            excerptList.remove(0);
            excerptList.forEach(excerpt -> allExpense += Double.parseDouble(excerpt.getExpense()));
            excerptList.forEach(excerpt -> allIncome += Double.parseDouble(excerpt.getIncome()));
            getExpenditure(excerptList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public double getExpenseSum() {
        return allExpense;
    }

    public double getIncomeSum() {
        return allIncome;
    }

    public void getExpenditure(List<Excerpt> total) {
        System.out.println("--------------------Операции с расходами-----------------------------");
        Map<String,Double> mapExpenditure = new HashMap<>();
        for (Excerpt i : total){
            String name = i.getDescription();
            double price = mapExpenditure.containsKey(name) ? mapExpenditure.get(name) : 0;
            price += Double.parseDouble(i.getExpense());
            mapExpenditure.put(name, price);
        }
        for (String description : mapExpenditure.keySet()) {
            System.out.printf("%s: %.2f %s%n", description, mapExpenditure.get(description), "руб");
        }

    }
}
