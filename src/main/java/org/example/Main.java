package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Fox", 14, 5);

        try (FileOutputStream fileOut = new FileOutputStream("user.bin");
             ObjectOutputStream obOut = new ObjectOutputStream(fileOut)){
             obOut.writeObject(student);
             obOut.close();
             System.out.println("Сериализация произошла.");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("user.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            student = (Student)in.readObject();
            System.out.println("Десериализация произошла.");
            System.out.println("" + student.getName());
            System.out.println("" + student.getAge());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}