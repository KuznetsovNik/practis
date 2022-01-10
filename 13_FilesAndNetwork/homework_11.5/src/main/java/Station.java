public class Station implements Comparable<Station>
{
    private Line line;
    private final String name;

    public Station(String name)
    {
        this.name = name;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Line getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Station o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Station{" +
                "line=" + line +
                ", name='" + name + '\'' +
                '}';
    }
}
