
public class AverageTemperature {

    public static final int AMOUNT_PATIENTS = 30;
    public static final float MAX_TEMPERATURE = 40.00f;
    public static final float MIN_TEMPERATURE = 32.00f;
    public static final float MAX_HELTHY = 36.90f;
    public static final float MIN_HELTHY = 36.20f;

    public static void main(String[] args) {
        float[] patients = new float[AMOUNT_PATIENTS];
        System.out.println("Температуры пациентов :");
        float median = 0.00f;
        int helthy = 0;
        for( int i = 0; i < patients.length; i++ ) {
            float temperature = (float) (MIN_TEMPERATURE+(Math.random()*(MAX_TEMPERATURE-MIN_TEMPERATURE)));
            patients[i] = temperature;
            System.out.printf("%.2f\n",patients[i]);
            median += patients[i];
            if (patients[i] <= MAX_HELTHY && MIN_HELTHY >= patients[i]){
                helthy++;
            }
        }
        System.out.printf("Средняя температура : %.2f\n", median/AMOUNT_PATIENTS);
        System.out.println("Количество здоровых : " + helthy);
    }
}
