package org.example;

import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
public class Yas {
    /**
     *
     * @param srcFilePath  原图地址
     * @param descFilePath 缩略图地址
     * @param quality      压缩程度，参数qality是取值0~1范围内
     * @return
     * @throws IOException
     */
    public static Boolean compressPic(String srcFilePath, String descFilePath, Float quality)
            throws IOException {
        ImageWriter writer = null;
        OutputStream out = null;
        ImageOutputStream ios = null;
        try {
            File input = new File(srcFilePath);
            BufferedImage image = ImageIO.read(input);
            // 指定写图片的方式为 jpg
            writer = ImageIO.getImageWritersByFormatName("jpg").next();
            // 先指定Output，才能调用writer.write方法
            File output = new File(descFilePath);
            out = new FileOutputStream(output);
            ios = ImageIO.createImageOutputStream(out);
            writer.setOutput(ios);

            ImageWriteParam param = writer.getDefaultWriteParam();
            if (param.canWriteCompressed()) {
                // 指定压缩方式为MODE_EXPLICIT
                param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                // 压缩程度，参数qality是取值0~1范围内
                param.setCompressionQuality(quality);
            }
            // 调用write方法，向输入流写图片
            writer.write(null, new IIOImage(image, null, null), param);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (out != null) {
                out.close();
            }
            if (ios != null) {
                ios.close();
            }
            if (writer != null) {
                writer.dispose();
            }
        }
    }


/**
 * @param srcFilePath     输入文件
 * @param descFilePath    输出文件
 * @param quality         设置大小1到0.7不变大小。0.9就是8倍。0.95就是5倍
 *
 *
 * */

    public void CurtDown(String srcFilePath,String descFilePath,Float quality) throws IOException{
        long start = System.currentTimeMillis();
//        String srcFilePath = "C:\\Users\\18165\\Downloads\\新建文件夹\\0.jpg";
//        String descFilePath = "C:\\Users\\18165\\Downloads\\新建文件夹\\00000.jpg";
//        Float quality = 0.95f;
        compressPic(srcFilePath, descFilePath, quality);
        long end = System.currentTimeMillis();
        System.out.println("压缩时间：" + (end - start) + "ms");
    }
}
