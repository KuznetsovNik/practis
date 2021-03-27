import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к папке");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        FileUtils.calculateFolderSize(path);
        long total = FileUtils.calculateFolderSize(path);
        System.out.println("Общий размер - " + FileUtils.friendlyFileSize(total));
    }
}

