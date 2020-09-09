package com.lab;

/**
 * @author Свирова Валерия R3137
 * В данном ENUM находятся все возможные варианты сложности лабораторных работ
 */
public enum Difficulty {
    NORMAL,
    HARD,
    TERRIBLE,
    ERROR;

    @Override
    public String toString(){
        if (this == NORMAL){
            return "Нормально";
        } else if(this == HARD){
            return "Сложно";
        } else if(this == TERRIBLE){
            return  "Очень сложно";
        } else if(this == ERROR){
            return "Ошибка чтения";
        }
        return super.toString();
    }
}
