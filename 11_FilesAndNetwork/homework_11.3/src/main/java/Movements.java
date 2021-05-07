import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                    String[] splitReplace = line.split("\\\"");
                    splitReplace[1] = splitReplace[1].replaceAll("," , "\\.");
                    StringBuilder sb = new StringBuilder(splitReplace[0]);
                    sb.append(splitReplace[1]);
                    String newLine = sb.toString();
                    String[] fragments2 = newLine.split(",");
                    if (fragments2.length != 8){
                        System.out.println("Ошибка");
                    }
                    String description = fragments2[5].replaceAll("\\s{2,}|\\d{2,}|\\+|\\.|\\\\|\\/|\\)|\\(|\\-" , " ").trim();
                    excerptList.add(new Excerpt(
                            description,
                            fragments2[6],
                            fragments2[7]));
                    continue;
                }
                String description2 = fragments[5].replaceAll("\\s{2,}|\\d{2,}|\\+|\\.|\\\\|\\/|\\)|\\(|\\-" , " ").trim();
                excerptList.add(new Excerpt(
                        description2,
                        fragments[6],
                        fragments[7]));
            }
            excerptList.remove(0);
            excerptList.forEach(excerpt -> allExpense += Double.parseDouble(excerpt.getExpense()));
            excerptList.forEach(excerpt -> allIncome += Double.parseDouble(excerpt.getIncome()));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public double getExpenseSum() {
        return allExpense;
    }

    public double getIncomeSum() {
        return allIncome;
    }

    public void getExpenditure(){
        Stream<Excerpt> stream = excerptList.stream();
        List<Excerpt> filtered = stream.filter(excerpt -> excerpt.getExpense().length() > 1)
                .collect(Collectors.toList());
        System.out.println("--------------------Операции с расходами-----------------------------");
        filtered.sort(Comparator.comparing(Excerpt::getDescription));
        filtered.forEach(System.out::println);
        Map<String , Double> mapExpenditure = filtered.stream()
                .collect(Collectors.toMap(
                        (Excerpt::getDescription)
                        ,excerpt -> Double.parseDouble(excerpt.getExpense())));
        for (String description : mapExpenditure.keySet()) {
            System.out.printf("%s ---> %f %s\n", description, mapExpenditure.get(description), "руб");
        }
    }
}
