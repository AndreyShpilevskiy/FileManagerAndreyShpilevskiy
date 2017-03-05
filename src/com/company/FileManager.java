package com.company;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static void createFile(String path, String name) throws IOException {
        try {
            File file = new File(path+name);
            boolean fvar = file.createNewFile();
            if (fvar){
                System.out.println("File has been created successfully");
            }
            else{
                System.out.println("File already present at the specified location");
            }
        } catch (IOException error) {
            System.out.println("Error");
            error.printStackTrace();
        }
    }

    public static void deleteFile(String path, String name) {
        File file = new File(path+name);
        if (file.canWrite()){
            boolean fvar = file.delete();
            if (fvar){
                System.out.println("File has been deleted successfully");
            }
            else{
                System.out.println("File doesn't delete");
            }
        }
        else{
            System.out.println("You don't have permission to delete file");
        }
    }

    public static void renameFile(String path, String name, String newName) {
        File file = new File(path+name);
        File newFile = new File(path+newName);
        boolean success = file.renameTo(newFile);
        if(!success){
            System.out.println("File doesn't rename");
        }
    }

    public static void findWord(String path, String name, String word) {
        File file = new File(path+name);
    }

    public static void replaceWord(String path, String name, String word) {
    }
}