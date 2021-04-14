import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к папке которую требуется скопировать: ");
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        System.out.println("Введите путь к папке в которую будет скопировано: ");
        String destination = scanner.nextLine();
        try {
            FileUtils.copyFolder(source, destination);
        }catch (Exception ex){
         ex.printStackTrace();
        }
    }
}
