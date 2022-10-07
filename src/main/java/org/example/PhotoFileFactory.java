package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoFileFactory extends FileFactory{
    @Override
    public List<FileBeen> table(String FileName){
        List<FileBeen> img=new ArrayList<FileBeen>();
        File dir =new File(FileName);
        File file[] =dir.listFiles();
        for (File item:file){
            if(item.isDirectory()){
                continue;
            }
            FileBeen fileBeen=new FileBeen();
            fileBeen.setFileProcess(item);
            String lastname =fileBeen.getFilelastname();
            if(PhotoBool(lastname)){
                img.add(fileBeen);
                System.out.println(item.getName());
            }
        }
//        img.get(0).getName();
        return img;
    }

    boolean PhotoBool(String lastname){
        if(lastname==null){
            return false;
        }
        return  lastname.equals(".jpg")||
                lastname.equals(".png")||
                lastname.equals(".jpeg");


    }

}
