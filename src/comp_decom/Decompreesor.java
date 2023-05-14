package comp_decom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompreesor {
    public static void method(File file) throws IOException {
        //get parent directory of  a file
        String parentDirectory = file.getParent();
        //read the file using input stream
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        //output the file using output stream
        FileOutputStream fos = new FileOutputStream(parentDirectory+"/decompressedfile");



        //create a byte array
        byte[] buffer = new byte[1024];
        int len;
        while((len=gzip.read(buffer))!=-1)
        {
            fos.write(buffer,0,len);
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
