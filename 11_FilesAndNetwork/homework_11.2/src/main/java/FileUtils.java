import java.io.*;
import java.nio.file.Files;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory){
        File source = new File(sourceDirectory);
        File destination = new File(destinationDirectory);
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdirs();
            }

            String files[] = source.list();
            for (String file : files) {
                File srcFile = new File(source, file);
                File destFile = new File(destination, file);
                copyFolder(srcFile.getPath(), destFile.getPath());
            }
        } else {
            try {
                Files.copy(source.toPath(), destination.toPath());
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}

