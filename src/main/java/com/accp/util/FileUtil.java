package com.accp.util;

import java.io.*;

public class FileUtil {
    public static void writeFile(File inFile,String directory,String fileName){
        File file=new File(directory);
        if (!file.exists()){
            file.mkdirs();
        }
        InputStream is=null;
        OutputStream os=null;
        try {
            is=new FileInputStream(inFile);
            os=new FileOutputStream(new File(file,fileName));
            byte[] b=new byte[1024];
            int len=-1;
            try {
                while ((len=is.read(b))!=-1){
                    os.write(b,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(os != null) {
                    os.flush();
                    os.close();
                }
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
