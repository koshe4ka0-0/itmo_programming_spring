package com.lab;
import java.time.LocalDate;
/**
 * @author Свирова Валерия R3137
 * От данного класса создаются все объекты класса  Person
 */

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDate birthday; //Поле может быть null
    private int height; //Значение поля должно быть больше 0
    private String passportID; //Поле не может быть null
    private Country nationality; //Поле не может быть null

    Person(String name, int year, int month , int day, int height, String passportID, Country nationality){
        this.name = name;
        this.height = height;
        this.passportID = passportID;
        this.nationality = nationality;
        if(year == 0 && month == 0 && day ==0) this.birthday = null;
        else this.birthday = LocalDate.of(year, month, day);
    }

    // сеттеры

    public void set_name(String name){ this.name = name; }

    public void set_height(int height){ this.height = height; }

    public void set_passportID(String passportID){ this.passportID = passportID; }

    public void set_nationality(Country nationality){ this.nationality = nationality; }

    // геттеры

    public String get_name(){ return this.name; }

    public java.time.LocalDate get_birthday(){ return this.birthday; }

    public Integer get_height(){ return this.height; }

    public String get_passportID(){ return this.passportID; }

    public Country get_nationality(){ return this.nationality; }

    @Override
    public String toString(){
        return "Имя: " + name + '\n'
                + "Дата рождения: " + birthday + '\n'
                + "Высота: " + height + '\n'
                + "Паспортные данные: " + passportID + '\n'
                + "Место рождения: " + nationality + '\n';
    }
}
