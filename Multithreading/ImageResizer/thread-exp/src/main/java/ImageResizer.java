import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer extends Thread{
    private final File [] files;
    private final int newWidth;
    private final String dstFolder;
    private final long start;

    public ImageResizer(File [] files, int newWidth, String dstFolder, long start){
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File file : files){
                BufferedImage image = ImageIO.read(file);
                if (image == null){
                    continue;
                }
                BufferedImage newImage = Scalr.resize(image,newWidth);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Finished " + (System.currentTimeMillis() - start) + "mls");
    }
}
