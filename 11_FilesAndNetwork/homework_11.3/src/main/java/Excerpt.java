import java.util.Objects;

public class Excerpt {
    private String description;
    private String income;
    private String expense;

    public Excerpt(String description, String income, String expense) {
        this.description = description;
        this.income = income;
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public String getIncome() {
        return income;
    }

    public String getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Excerpt{" +
                ", Описание ='" + description + '\'' +
                ", Приход ='" + income + '\'' +
                ", Расход ='" + expense + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Excerpt)) return false;
        Excerpt excerpt = (Excerpt) o;
        return Objects.equals(getDescription(), excerpt.getDescription()) && Objects.equals(getIncome(), excerpt.getIncome()) && Objects.equals(getExpense(), excerpt.getExpense());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getIncome(), getExpense());
    }
}
