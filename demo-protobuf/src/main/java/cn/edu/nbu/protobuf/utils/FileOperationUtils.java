package cn.edu.nbu.protobuf.utils;

import lombok.experimental.UtilityClass;

import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/10-5:11 PM
 * @since 1.0
 */
@UtilityClass
public class FileOperationUtils {

    public static void writeFileByte(byte[] b,String path){
        File file = new File(path);
        long size = file.length();
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(b);
            fos.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static byte[] readFileByte(String path){
        File file = new File(path);
        long size = file.length();
        byte[] result = new byte[(int)size];
        try(FileInputStream fis = new FileInputStream(file)){
            if(fis.read(result) < 0){
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
