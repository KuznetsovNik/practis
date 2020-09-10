public class ProjectX {

    public static final int SIZE_ARRAYS = 3;

    public static void main(String[] args) {
        int finalSize = SIZE_ARRAYS;
        String [][] projectX =
                {{"X"," "," "," "," "," ","X"},
                {" ","X"," "," "," ","X"," "},
                {" "," ","X"," ","X"," "," "},
                {" "," "," ","X"," "," "," "},
                {" "," ","X"," ","X"," "," "},
                {" ","X"," "," "," ","X"," "},
                {"X"," "," "," "," "," ","X"}};
        while (finalSize > 0) {
            for (int i = 0; i < projectX.length; i++) {
                System.out.println(" ");
                for (int j = 0; j < projectX[i].length; j++) {
                    System.out.print("\t" + projectX[i][j]);
                }
            }
            finalSize--;
        }
    }
}

