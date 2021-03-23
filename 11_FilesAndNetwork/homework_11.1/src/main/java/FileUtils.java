import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path){
        long weight = 0;
        File file = new File(path);
        try{
            if (file.isDirectory()){
                System.out.println("Размер папки - " + file.getName() + " составляет - " + friendlyFileSize(file.length()));
            }else {
                System.out.println("Размер файла - " + file.getName() + " составляет - " + friendlyFileSize(file.length()));
            }
            weight += file.length();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return weight;
    }

    private static String friendlyFileSize(long size){
        String unit = "байт";
        if (size > 1024){
            size = size/1024;
            unit = "КВ";
        }
        if (size > 1024){
            size = size/1024;
            unit = "МВ";
        }
        if (size > 1024){
            size = size/1024;
            unit = "GB";
        }
        return " (" + size + ") " + unit;
    }
}
