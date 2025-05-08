package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    
    public final String UPLOAD_DIR="C:\\Users\\manje\\OneDrive\\Documents\\SpringBootProjects in VS code\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile f1){
        boolean f=false;
     
        try {
            InputStream is=f1.getInputStream();
            byte data[]=new byte[is.available()];
            is.read(data);
            //write
            FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+f1.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();
            f=true;
            
            
             
        } catch (Exception e) {
          e.printStackTrace();
        }

        return f;
    }

}
