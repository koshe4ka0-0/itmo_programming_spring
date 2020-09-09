package com.lab;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

/**
 * @author Свирова Валерия R3137
 * Данный класс осуществляет работу всей программы
 */

public class Lab5{
    public static void main(String[] args) {

        System.out.println("Добро пожаловать! Нажмите Enter, чтобы начать работу.");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        String file_name;
        HashMap<String, Labwork> hashMap = new HashMap<>();
        LocalDateTime time = LocalDateTime.now();

        if(args.length == 0){
            file_name = "temp_file.csv";
            System.out.println("Вы не задали имя файла");
            System.exit(1);
        }
        else file_name = args[0];
        File file = new File(file_name);
        if(file.exists()) Filework.read(file_name, hashMap);
        else System.out.println("Файла " + file_name + "не существует, но он был создан.");

        while(!answer.equals("exit")) {
            System.out.println("Введите команду: ");
            answer = sc.nextLine();
            Commands.choose(answer, file_name, time, hashMap);
        }
    }
}
