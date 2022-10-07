package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String FILE_NAME ="C:\\Users\\18165\\Downloads\\新建文件夹5";//导入文件路径
        String FILE_NAME_TARGET="C:\\Users\\18165\\Downloads\\目标\\";
        PhotoFileFactory fileFactory =new PhotoFileFactory();
//        System.out.println(FILE_NAME);
        List<FileBeen> files=fileFactory.table(FILE_NAME);
        for (FileBeen file:files){
            FileBeen file1=file;
            boolean bool =gotochange(file1);
            if(bool){
            file1=new FileBeen();
            file1.setFileProcess(new File(file.getFileSelf().getParent()+"\\"+file.getFileFirstName()+"\\"+file.getFileFirstName()+file.getFilelastname()
            ));
            }
            String past=new BaiduHttp().pictrans(file1.getFileSelf());
            new BaseToImage().convertBase64ToImage(past,file1,FILE_NAME_TARGET);
            if(bool){file1.getFileSelf().getParentFile().delete();}
        }

        }


        public static boolean gotochange(FileBeen file) throws IOException {
            if(file.getFileSelf().length()>=2*1024*1024){
                Yas yas=new Yas();
                String newfile =file.getFileSelf().getParent()+"\\"+file.getFileFirstName();
                new File(newfile).mkdir();
                yas.CurtDown(
                        file.getFileSelf().getPath(),
                        newfile+"\\"+file.getFileFirstName()+file.getFilelastname(),
                        0.95f);
                System.out.println("wenjiandasxiao"+file.getFileSelf().length());
                return true;
            }
            System.out.println("wenjiandasxiao"+file.getFileSelf().length());
            return false;
        }
    }
