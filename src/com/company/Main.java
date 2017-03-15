package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        System.out.println("1 - Create file");
        System.out.println("2 - Delete file");
        System.out.println("3 - Rename file");
        System.out.println("4 - Find word");
        System.out.println("5 - Replace word");
        System.out.println("0 - Exit");
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        int flag = 1;
        while (flag == 1) {
            System.out.println("Please choose your option (For example: '1')");
            int option = scanner.nextInt();
            if (option == 0) {
                flag = 0;
            } else if (option == 1) {
                System.out.println("Creating a new file.");
                System.out.println("Please enter path (For example: 'E:/')");
                String path = scanner.next();
                System.out.println("Please enter filename (For example: 'test.txt')");
                String fileName = scanner.next();
                System.out.println("Please enter text of file ('Hello')");
                String content = scanner.next();
                fileManager.createFile(path, fileName, content);
            } else if (option == 2) {
                System.out.println("Deleting a file.");
                System.out.println("Please enter path (For example: 'E:/')");
                String path = scanner.next();
                System.out.println("Please enter filename (For example: 'test.txt')");
                String name = scanner.next();
                fileManager.deleteFile(path, name);
            } else if (option == 3) {
                System.out.println("Renaming a file.");
                System.out.println("Please enter path (For example: 'E:/')");
                String path = scanner.next();
                System.out.println("Please enter filename (For example: 'test.txt')");
                String name = scanner.next();
                System.out.println("Please enter new filename (For example: 'supertext.txt')");
                String newName = scanner.next();
                fileManager.renameFile(path, name, newName);
            } else if (option == 4) {
                System.out.println("Searching the word in file.");
                System.out.println("Please enter path (For example: 'E:/')");
                String path = scanner.next();
                System.out.println("Please enter filename (For example: 'supertext.txt)");
                String name = scanner.next();
                System.out.println("Please enter word from text (For example: 'text')");
                String word = scanner.next();
                fileManager.searchWord(args);
            } else if (option == 5) {
                System.out.println("Replacing the word in file.");
                System.out.println("Please enter path (For example: 'E:/')");
                String path = scanner.next();
                System.out.println("Please enter filename (For example: 'supertext.txt')");
                String name = scanner.next();
                System.out.println("Please enter word from text for change (For example: 'text')");
                String word = scanner.next();
                System.out.println("Please enter new word for change (For example: 'noText')");
                String newWord = scanner.next();
                fileManager.replaceWord(args);

            }
        }
    }
}