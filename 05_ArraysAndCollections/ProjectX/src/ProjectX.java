public class ProjectX {
    public static void main(String[] args) {
        String [][] projectX = {{"X"," "," "," "," "," ","X"},
                {" ","X"," "," "," ","X"," "},
                {" "," ","X"," ","X"," "," "},
                {" "," "," ","X"," "," "," "},
                {" "," ","X"," ","X"," "," "},
                {" ","X"," "," "," ","X"," "},
                {"X"," "," "," "," "," ","X"}};
        for (int i = 0; i < projectX.length; i++){
            System.out.println(" ");
            for (int j = 0; j < projectX[i].length; j++){
                System.out.print("\t"+projectX[i][j]);
            }
        }
    }
}
