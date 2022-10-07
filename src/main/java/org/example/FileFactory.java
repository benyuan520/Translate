package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFactory {

    public List<FileBeen> table(String FileName){
        List<FileBeen> fileBeens =new ArrayList<FileBeen>();
        File dir =new File(FileName);
        File file[] =dir.listFiles();
        for (File item:file){
            if(!item.isDirectory()){
            FileBeen fileBeen=new FileBeen();
            fileBeen.setFileSelf(item);

                fileBeens.add(fileBeen);
                System.out.println(item.getName());
            }
        }
//        img.get(0).getName();
        return fileBeens;
    }

}
