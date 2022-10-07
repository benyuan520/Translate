package org.example;

import java.io.File;

public class FileBeen {
    public FileBeen() {
    }

    public String getFileFirstName() {
        return fileFirstName;
    }

    public void setFileFirstName(String fileFirstName) {
        this.fileFirstName = fileFirstName;
    }

    public String getFilelastname() {
        return filelastname;
    }

    public void setFilelastname(String filelastname) {
        this.filelastname = filelastname;
    }

    public File getFileSelf() {
        return fileSelf;
    }

    public void setFileSelf(File fileSelf) {
        this.fileSelf = fileSelf;
    }

    /**
     * 对文件本身进行加工将其分为名字和后缀，并保存文件本身
     * */
    public void setFileProcess(File fileSelf) {
        String name = fileSelf.getName();
//        System.out.println(name);
        this.fileFirstName= name.substring(0,name.lastIndexOf("."));
        this.filelastname = name.substring(name.lastIndexOf("."),name.length());
        this.fileSelf = fileSelf;
//        System.out.println(this.filelastname);
    }
    /**
     * @param fileFirstName 文件名
     * @param fileLastName 文件后缀
     * @param fileSelf 文件名本身
     *
     * */
    private String fileFirstName;


    private String filelastname;

    private File fileSelf;
}
