import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к папке");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File directory = new File(path);
        try {
            FileUtils.calculateFolderSize(directory.getPath());
            System.out.println("В ней содержатся:");
            if (directory.isDirectory()) {
                for (File folder : directory.listFiles()) {
                    if (folder.isDirectory()) {
                        System.out.println("\n \t Папка: " + folder.getName());
                        FileUtils.calculateFolderSize(folder.getPath());
                        System.out.println("В ней содержатся:");
                        for (File file : folder.listFiles()) {
                            if (file.isDirectory()) {
                                System.out.println("\t Папка:" + file.getName());
                            } else {
                                System.out.println("\t Файл:" + file.getName());
                            }
                            FileUtils.calculateFolderSize(file.getPath());
                        }
                    } else {
                        System.out.println("\n \t Файл:" + folder.getName());
                        FileUtils.calculateFolderSize(folder.getPath());
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
