package com.lab;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Свирова Валерия  R3137
 * Данный класс хранит в себе все команды, которые взаимодействуют с файлами
 */

public class Filework {

    /**
     * Метод, который переводит коллекцию типа HashMap в строку
     * @param hashMap коллекция, которую мы переводим в строку
     * @return строку
     */

    private static String to_text(HashMap<String, Labwork> hashMap){
        TreeMap<String, Labwork> answer = Commands.sort_by_key(hashMap);
        String text = "";
        for (Map.Entry<String, Labwork> entry : answer.entrySet()){
            Labwork lab = entry.getValue();
            String sep = ",";
            text += entry.getKey() + sep;
            text+= lab.get_id() + sep;
            text += lab.get_name() +sep;
            text += lab.get_coordinates().Get_x() +sep;
            text += lab.get_coordinates().Get_y() +sep;
            text += lab.get_creationDate() + sep;
            text += lab.get_minimalPoint() +sep;
            text += lab.get_personalQualitiesMaximum() + sep;
            text += lab.get_difficulty().toString() + sep;
            text += lab.get_author().get_name() + sep;
            text += lab.get_author().get_birthday() + sep;
            text += lab.get_author().get_height() +sep;
            text += lab.get_author().get_passportID() +sep;
            text += lab.get_author().get_nationality().toString() + "\n";
        }
        return text;
    }

    /**
     * Метод, который сохраняет переведенную в текст коллекцию hashMap в файл file_name c помощью буфферезированного потока
     * @param hashMap коллекция, переведенная в текст
     * @param file_name файл, в который мы сохраняем коллекцию
     *
     */

    public static void save(String file_name, HashMap<String, Labwork> hashMap) {
        String text = to_text(hashMap);
        try (FileOutputStream out = new FileOutputStream(file_name);
             BufferedOutputStream buffer_out = new BufferedOutputStream(out)) {
            byte[] buffer = text.getBytes("cp1251");
            buffer_out.write(buffer, 0, buffer.length);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод, который считывает строку из файла file_name
     * @param file_name файл, из которого мы считываем строки
     * @return строку
     */

    private static String buf_read(String file_name){
        String str = "";
        try(FileInputStream in = new FileInputStream(file_name);
            BufferedInputStream buffer_in = new BufferedInputStream(in)){
            int i = buffer_in .read();
            while (i != -1) {
                str += (char) i;
                i = buffer_in.read();
            }
            buffer_in.close();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            return "";
        }
        return str;
    }

    /**
     * Метод, который разделяет полученную строку на поля Labwork и вносит правки с кодировкой
     * @param hashMap коллекция, которую мы переводим в строку
     * @param file_name файл, из которого мы читаем строки
     */

    public static void read(String file_name, HashMap<String, Labwork> hashMap){
            String str = buf_read(file_name);
            String encoding = "windows-1251";
        String str_i = null;
        try {
            str_i = new String(str.getBytes("ISO-8859-1"), encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String [] lines = str_i.split("\n");
            for(String line: lines){
                String [] array = work_with_lines(line, 14);
                Labwork.set_lab(array, hashMap);
            }

    }

    /**
     * Метод, который делит поля по count(количество нужных полей), если кол-во строк не кратно, количеству полей Labwork,
     * то какое-то поле точно пропущенно и выдается ошибка чтения файла
     * @param big_line строка, которую мы делим на поля
     * @count количество полей одного объекта
     * @return массив из полей
     */

    public static String[] work_with_lines(String big_line, int count) {
        String [] array = new String[count];
            String[] small_line = big_line.split(",");
            if (small_line.length % count !=0) {
                array[0] = "Файлы для чтения повреждены или файл был пуст";
            } else {
                for (int i = 0; i < small_line.length; i++) {
                    array[i] = small_line[i];
                }
            }
        return array;
    }

    //Чтение команд из файла и их выполнение
    public static void execute_script(String file, HashMap<String, Labwork> hashMap, String file_name, LocalDateTime time){
        String str = buf_read(file);
        String [] lines = str.split("\n");
        for(String line: lines){
            Commands.choose(line, file_name, time, hashMap);
        }
    }
}
