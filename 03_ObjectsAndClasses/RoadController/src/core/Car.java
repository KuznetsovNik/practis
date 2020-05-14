package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;


    // String number
    public void setNumber(String number)
    {
     this.number = number;
    }
    public String getNumber()
    {
        return number;
    }

    // int height
    public void setHeight() {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    // double weight
    public  void setWeight() {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    // boolean hasVehicle
    public void setHasVehicle() {
        this.hasVehicle = hasVehicle;
    }
    public boolean getHasVehicle() {
        return hasVehicle;
    }

    // boolean isSpecial
    public  void setIsSpecial() {
        this.isSpecial = isSpecial;
    }

    public boolean getIsSpecial() {
        return isSpecial;
    }


    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}