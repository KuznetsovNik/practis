public class Arrays {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        System.out.println(text);
        String [] arrays = text.split(",?\\s+");
        int [] index = new int[7];
        index [0] = 6;
        index [1] = 5;
        index [2] = 4;
        index [3] = 3;
        index [4] = 2;
        index [5] = 1;
        index [6] = 0;
        int x = 0;
        int replace;
        while (x < 7){
            replace = index[x];
            System.out.print(" " + arrays[replace]);
            x = x + 1;
        }
    }
}
