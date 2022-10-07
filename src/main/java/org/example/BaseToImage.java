package org.example;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class BaseToImage {

    public void convertBase64ToImage(String base64Code,FileBeen fileBeen,String target){
        BufferedImage image = null;
        byte[] imageByte = null;
        try {
            imageByte = DatatypeConverter.parseBase64Binary(base64Code);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(new ByteArrayInputStream(imageByte));
            bis.close();
            String fileroad=target+fileBeen.getFileSelf().getName();
            File outputfile = new File(fileroad);
            ImageIO.write(image, fileBeen.getFilelastname().substring(1,fileBeen.getFilelastname().length()), outputfile);//中间路径
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
