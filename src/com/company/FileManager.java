package com.company;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    private Scanner scanner;
    private FileWriter fw;
    private BufferedWriter bw;

    public FileManager() {
        this.scanner = new Scanner(System.in);
    }

    public String createFile(String path, String fileName, String content) {
        File file = new File(path+fileName);

        boolean exists = exists(file);

        if (exists) {
            System.out.println("Файл " + fileName + " существует, начинаю запись данных...");
            writeToFile(file, content);
        } else {
            System.out.println("Файл " + fileName + " не существует...Создать его? (y/n)");
            String userInput = scanner.nextLine();
            if ("y".equals(userInput)) {
                System.out.println("Файл создан. Получилось!:)");
                //добавить возможность принимать ответ без учета регистра, доделать
                try {
                    file.createNewFile();
                    writeToFile(file, content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if ("n".equals(userInput)) {
                System.out.println("Ваш ответ 'нет', файл не будет создан. Пока!");
            }
        }
        return "Done!";
    }

    private boolean exists(File file) {
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }


    private void writeToFile(File file, String content) {
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        if(!success) {
            System.out.println("File doesn't rename");
        }

    }
    public static void searchWord (String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String searchWord = scanner.next(); // слово заменить на нужное
        FileInputStream fis = new FileInputStream(new File("E:/supertext.txt")); // путь заменить на нужный
        byte[] content = new byte[fis.available()];
        fis.read(content);
        fis.close();
        String[] lines = new String(content, "Cp1251").split("\n"); // кодировку указать нужную
        int i = 1;
        for (String line : lines) {
            String[] words = line.split(" ");
            int j = 1;
            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    System.out.println("Найдено в " + i + "-й строке, " + j + "-е слово");
                }
                j++;
            }
            i++;
        }
    }

    public static void replaceWord(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("e:\\supertext.txt")); // путь заменить на нужный
        String line = "";
        String FileContent = "";
        String NL = System.getProperty("line.separator");
        while ((line = br.readLine()) != null) {
            FileContent = FileContent + line + NL;
        }
        br.close();
        FileContent = FileContent.replaceAll("text", "noText"); // указать необходимые слова
        System.out.println(FileContent);
        BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\supertext.txt")); // путь заменить на нужный
        bw.write(FileContent);
        bw.close();
    }
}




