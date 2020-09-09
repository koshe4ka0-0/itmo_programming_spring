package com.lab;
/**
 * @author Свирова Валерия R3137
 * В данном ENUM находятся все возможные варианты мест жительства
 */

public enum Country {
    RUSSIA,
    UNITED_KINGDOM,
    USA,
    GERMANY,
    INDIA,
    ERROR;

    @Override
    public String toString(){
        if (this == RUSSIA){
            return "Россия";
        } else if(this == UNITED_KINGDOM){
            return "Великобритания";
        } else if(this == USA){
            return  "США";
        } else if(this == GERMANY){
            return "Германия";
        } else if(this == INDIA){
            return "Индия";
        } else if (this == ERROR){
            return "Ошибка чтения";
        }
        return super.toString();
    }
}

