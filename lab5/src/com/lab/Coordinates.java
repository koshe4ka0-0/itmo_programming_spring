package com.lab;

/**
 * @author Свирова Валерия R3137
 * От данного класса создаются все Координаты, в которых хранятся Лабораторные Работы
 */
public class Coordinates {
    private Float x; //Максимальное значение поля: 332, Поле не может быть null
    private Long y; //Поле не может быть null

    public Coordinates( Float x, Long y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return Координату X
     */
    public float Get_x(){
        return x;
    }

    /**
     * @return Координату У
     */
    public Long Get_y(){
        return y;
    }
}

