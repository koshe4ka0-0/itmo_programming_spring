package com.lab;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
/**
 * @author Cвирова Валерия R3137
 * От данного класса создаются все лабораторные Работы
 */

public class Labwork implements Comparable<Labwork>, Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Double personalQualitiesMaximum; //Поле не может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле может быть null
    private Person author; //Поле не может быть null

    public Labwork(String name, Coordinates coordinates, Integer minimalPoint, Double personalQualitiesMaximum, Difficulty difficulty, Person author){
        this.name = name;
        this.coordinates = coordinates;
        this.minimalPoint = minimalPoint;
        this.personalQualitiesMaximum = personalQualitiesMaximum;
        this.difficulty = difficulty;
        this.author = author;
        this.id = this.hashCode();
        this.creationDate = LocalDateTime.now();
    }

    //сеттеры

    public void set_id(Integer id){this.id = id;}

    public void set_name(String name){ this.name = name; }

    public void set_coordinates(Coordinates coordinates){ this.coordinates = coordinates; }

    public void set_minimalPoint(Integer minimalPoint){ this.minimalPoint = minimalPoint; }

    public void set_personalQualitiesMaximum(Double personalQualitiesMaximum){ this.personalQualitiesMaximum = personalQualitiesMaximum; }

    public void set_difficulty(Difficulty difficulty){ this.difficulty = difficulty; }

    public void set_author(Person author){ this.author = author; }

    private void set_creationDate(String date){
        LocalDateTime creationDate = LocalDateTime.parse(date);
        this.creationDate = creationDate;
    }

    //геттеры

    public Integer get_id(){ return this.id; }

    public String get_name(){ return this.name; }

    public Coordinates get_coordinates(){ return this.coordinates; }

    public java.time.LocalDateTime get_creationDate(){ return this.creationDate; }

    public Integer get_minimalPoint(){ return this.minimalPoint; }

    public double get_personalQualitiesMaximum(){ return this.personalQualitiesMaximum; }

    public Difficulty get_difficulty(){ return this.difficulty; }

    public Person get_author(){ return this.author; }


    @Override
    public String toString(){
        return " ID лабораторной работы: " + id + '\n'
                + "Название лабораторной работы: " + name + '\n'
                + "Дата создания: " + creationDate + '\n'
                + "Проходной балл: " + minimalPoint + '\n'
                + "Максимальное количество баллов за личные качества: " + personalQualitiesMaximum + '\n'
                + "Сложность: " + difficulty + '\n'
                + "Выполнил: " + '\n' + author;
    }

    /**
     * @param lab объект класса LabWork
     * @return 1, если creationDate больше и -1, если creationDate меньше
     */
    @Override
    public int compareTo(Labwork lab) {

        if (this.creationDate.compareTo(lab.creationDate) >0)
            return 1;
        else if (this.creationDate.compareTo(lab.creationDate) <0)
            return -1;
        else
            return 0;
    }


    /**
     * @param array массив из данных, которые будут записаны в Labwork
     * @param hashMap коллекция, в которую будут записаны объекты
     * Метод, который заполняет коллекцию объектами с полями, которые записаны в массив array
     */
    public static void set_lab(String [] array, HashMap<String, Labwork> hashMap){
        String key;
        String name;
        float x;
        Long y;
        Integer minimalPoint;
        Double personalQualitiesMaximum;
        String author_name;
        int day;
        int month;
        int year;
        int author_height;
        String passportID;
        Difficulty difficulty;
        Country nationality;

        //Если в методе work_in_lines количество стро было не кратно количеству полей, то выводится ошибка
        //Если в считываемой строке, на месте поля был пропуск и данные были утеряны, запишем туда то, что нельзя записать в
        //Переменную по условию, чтобы понять,где данные были потеряны
        if(array[0].equals("Файлы для чтения повреждены")){System.out.println(array[0]);}
        else {
            key = array[0];

            if (array[2].isEmpty()) {
                name = null;//поле name в Labwork не может быть равно null, если в массиве на месте поля нет информации, запишем туда null, что значит пустые данные
            } else {
                name = array[2];
            }

            try {
                x = Float.parseFloat(array[3]);
                y = Long.parseLong(array[4]);
            } catch (Exception e) {
                x = 400;
                y = null;
            }
            Coordinates coordinates = new Coordinates(x, y);

            try {
                minimalPoint = Integer.parseInt(array[6]);
            } catch (Exception e) {
                minimalPoint = null;
            }

            try {
                personalQualitiesMaximum = Double.parseDouble(array[7]);
            } catch (Exception e) {
                personalQualitiesMaximum = -1.0;
            }

            if (array[9].isEmpty()) author_name = "-";
            else author_name = array[9];

            if (array[10].isEmpty() || array[10].equals("null")) {
                day = 0;
                month = 0;
                year = 0;
            } else {
                String[] birthday_parts = array[10].split("-");
                day = Integer.parseInt(birthday_parts[2]);
                month = Integer.parseInt(birthday_parts[1]);
                year = Integer.parseInt(birthday_parts[0]);
            }

            try {
                author_height = Integer.parseInt(array[11]);
            } catch (Exception e) {
                author_height = -1;
            }

            if (array[12].isEmpty()) passportID = null;
            else passportID = array[12];

            if (array[8].equals("Нормально")) {
                difficulty = Difficulty.NORMAL;
            } else if (array[8].equals("Сложно")) {
                difficulty = Difficulty.HARD;
            } else if (array[8].equals("Очень сложно")) {
                difficulty = Difficulty.TERRIBLE;
            } else {
                difficulty = Difficulty.ERROR;
            }

            if (array[13].equals("Россия")) {
                nationality = Country.RUSSIA;
            } else if (array[13].equals("Великобритания")) {
                nationality = Country.UNITED_KINGDOM;
            } else if (array[13].equals("США")) {
                nationality = Country.USA;
            } else if (array[13].equals("Индия")) {
                nationality = Country.INDIA;
            } else if (array[13].equals("Германия")) {
                nationality = Country.GERMANY;
            } else {
                nationality = Country.ERROR;
            }

            Integer id;

            Person author = new Person(author_name, year, month, day, author_height, passportID, nationality);
            Labwork lab = new Labwork(name, coordinates, minimalPoint, personalQualitiesMaximum, difficulty, author);
            lab.set_creationDate(array[5]);

            try {
                id = Integer.parseInt(array[1]);
            } catch (Exception e) {
                id = null;
            }

            if (id != null && id > 0) {
                lab.set_id(id);
            }
            hashMap.put(key, lab);
        }
    }

}




