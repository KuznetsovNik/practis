public class Arrays {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] arrays = text.split(",?\\s+");
        for (int i = arrays.length - 1; i >= 0 ; i--){
            System.out.print(arrays[i] + " ");
        }
    }
}
