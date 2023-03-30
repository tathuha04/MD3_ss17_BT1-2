import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyBinary {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("E:\\JAVACORE\\baitap1ss17\\product.txt");
        File targetFile = new File("copyFile.txt");

        if (!targetFile.exists()){
            targetFile.createNewFile();
        }
        FileInputStream fis = new FileInputStream(sourceFile);
        FileOutputStream out = new FileOutputStream(targetFile);
        byte c ;
        while ((c = (byte) fis.read()) != -1) {
            out.write(c);
        }
        fis.close();
        out.close();
    }
}
