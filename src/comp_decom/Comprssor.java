package comp_decom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Comprssor {
    public static void method(File file) throws IOException {
        //get parent directory of  a file
        String parentDir = file.getParent();
        //read the file using input stream
        FileInputStream fis = new FileInputStream(file);
        //output the file using output stream
        FileOutputStream fos = new FileOutputStream(parentDir+"/compressedfile.gz");
        //zip the output file
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        //create a byte array
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1)
        {
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();

    }
    public static void main(String[] args) throws IOException{
        File path = new File("");
        method(path);

    }

}
