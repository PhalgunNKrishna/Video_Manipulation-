import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class VideoFileIO {

    public void InOut() {
        final int BUFFERSIZE = 4 * 1024;
        String sourceFilePath = "C:/Users/Charles Arellano/Desktop/Video Manipulation Project/sampleVideo.mp4";
        String outputFilePath = "C:/Users/Charles Arellano/Desktop/Video Manipulation Project/Myu/OutputVid.mp4";

        try (
        FileInputStream fin = new FileInputStream(new File(sourceFilePath)); FileOutputStream fout = new FileOutputStream(new File(outputFilePath));
        ) {

        byte[] buffer = new byte[BUFFERSIZE];

        while (fin.available() != 0) {
        fin.read(buffer);
        fout.write(buffer);
        }

        } catch (Exception e) {
        System.out.println("Something went wrong! Reason: " + e.getMessage());
        }
    }
    

}