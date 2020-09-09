package com.lab;
import java.util.*;
import java.util.TreeMap;
import java.time.LocalDateTime;

/**
 * @author Свирова Валерия R3137
 * Класс содежит в себе все команды, которые содержит лабораторная работа
 */
public class Commands {

    static HashMap<String, Labwork> insert(String key) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название лабораторной работы: ");
        String name_of_lab = sc.nextLine();
        while(true){
            if(name_of_lab.isEmpty()){
                System.out.println("Введите название лабораторной. Строка не должна быть пустой.");
                name_of_lab = sc.nextLine();
            } else {break;}
        }

        System.out.println("Введите координату x: ");
        String str = sc.nextLine();
        Float x;
        while(true) {
            try {
                x = Float.parseFloat(str);
                if(x <= 332) break;
                else System.out.println("Что-то пошло не так. Повторите попытку. Число должно быть не больше 332");
                str = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Повторите попытку. Число должно быть не больше 332");
                str = sc.nextLine();
                }
        }

        System.out.println("Введите координату y: ");
        str = sc.nextLine();
        Long y;
        while(true) {
            try {
                y = Long.parseLong(str);
                break;
            } catch (Exception e){
                System.out.println("Что-то пошло не так. Повторите попытку. Число должно быть целым.");
                str = sc.nextLine();
            }
        }

        Coordinates coordinates = new Coordinates(x, y);

        System.out.println("Введите проходной балл: ");
        str = sc.nextLine();
        Integer minimalPoint;
        while(true) {
            try {
                if(str.equals("")) {
                    minimalPoint = null;
                    break;
                }else{
                    minimalPoint = Integer.parseInt(str);
                    if(minimalPoint > 0 && minimalPoint < 100)break;
                    else System.out.println("Что-то пошло не так. Повторите попытку. Число должно быть целым и принадлежать отрезку (0;100)");
                    str = sc.nextLine();
                }

            }catch(Exception e){
                System.out.println("Что-то пошло не так. Повторите попытку. Число должно быть целым и принадлежать отрезку (0;100)");
                str = sc.nextLine();
            }
        }

        System.out.println("Введите максимльный балл за личные качества: ");
        str = sc.nextLine();
        Double maxPersonalPoint;
        while (true) {
            try {
                maxPersonalPoint = Double.parseDouble(str);
                if(maxPersonalPoint > 0 && maxPersonalPoint <100)break;
                else System.out.println("Что-то пошло не так. Повторите попытку. Число должно принадлежать отрезку (0; 100)");
                str = sc.nextLine();
            }catch(Exception e){
                System.out.println("Что-то пошло не так. Повторите попытку. Число должно принадлежать отрезку (0; 100)");
                str = sc.nextLine();
            }
        }


        System.out.println("Какова сложность лабораторной работы. Выберите вариант Сложно/Нормально/Очень сложно: ");
        String string_difficulty = sc.nextLine();
        Difficulty difficulty;

        label:
        while(true) {
            switch (string_difficulty.toLowerCase()) {
                case "нормально":
                    difficulty = Difficulty.NORMAL;
                    break label;
                case "сложно":
                    difficulty = Difficulty.HARD;
                    break label;
                case "очень сложно":
                    difficulty = Difficulty.TERRIBLE;
                    break label;
                default:
                    System.out.println("Что-то пошло не так. Повторите попытку. Выберите сложность работы из трех вариантов: Сложно/Нормально/Очень сложно");
                    string_difficulty = sc.nextLine();
                    break;
            }
        }

        System.out.println("Введите имя: ");
        String name_of_author = sc.nextLine();
        while(true){
            if(name_of_author.isEmpty()){
                System.out.println("Что-то пошло не так. Повторите попытку. Строка не может быть пустой");
                name_of_author = sc.nextLine();
            } else break;
        }

        System.out.println("Введите дату рождения в формате дд/мм/гггг: ");
        String birthday_of_author = sc.nextLine();
        int day;
        int month;
        int year;
        while (true) {
            try {
                if (birthday_of_author.isEmpty()) {
                    day = 0;
                    month = 0;
                    year = 0;
                    break;
                }
                String[] birthday_parts = birthday_of_author.split("/");
                day = Integer.parseInt(birthday_parts[0]);
                month = Integer.parseInt(birthday_parts[1]);
                year = Integer.parseInt(birthday_parts[2]);

                if(year > 1920 && year < 2016)break;
                else System.out.println("Что-то пошло не так. Повторите попытку. Введите дату в формате дд/мм/гг");
                birthday_of_author = sc.nextLine();
            }catch(Exception e){
                System.out.println("Что-то пошло не так. Повторите попытку. Введите дату в формате дд/мм/гг");
                birthday_of_author = sc.nextLine();
            }
        }


        System.out.println("Введите высоту: ");
        str = sc.nextLine();
        int height_of_author;
        while(true) {
            try {
                 height_of_author = Integer.parseInt(str);
                if (height_of_author > 0) break;
                else System.out.println("Что-то пошло не так. Повторите попытку. Число должно быть больше нуля.");
                str = sc.nextLine();
            }catch(Exception e){
                System.out.println("Что-то пошло не так. Повторите попытку. Число олжно быть больше нуля.");
                str = sc.nextLine();
            }
        }

        System.out.println("Введите номер паспорта: ");
        String PasswordID_of_author= sc.nextLine();
        String regex = "\\d+";
        while (true) {
             if(!PasswordID_of_author.isEmpty() && PasswordID_of_author.matches(regex) && PasswordID_of_author.length()==10)break;
             else System.out.println("Что-то пошло не так. Повторите попытку. Строка не может быть пустой, должна содержать 10 цифр.");
            PasswordID_of_author = sc.nextLine();
        }

        System.out.println("Введите страну Россия/Великобритания/США/Индия/Германия : ");
        String nationality_of_author = sc.nextLine();
        Country nationality;

        label1:
        while(true) {
            switch (nationality_of_author.toLowerCase()) {
                case "россия":
                    nationality = Country.RUSSIA;
                    break label1;
                case "великобритания":
                    nationality = Country.UNITED_KINGDOM;
                    break label1;
                case "сша":
                    nationality = Country.USA;
                    break label1;
                case "индия":
                    nationality = Country.INDIA;
                    break label1;
                case "германия":
                    nationality = Country.GERMANY;
                    break label1;
                default:
                    System.out.println("Что-то пошло не так. Повторите попытку. Вы можете выбрать ответ только из 5 вариантов: Россия/Великобритания/США/Индия/Германия");
                    nationality_of_author = sc.nextLine();
                    break;
            }
        }

        Person author = new Person(name_of_author, year, month, day, height_of_author, PasswordID_of_author, nationality);
        Labwork lab =  new Labwork(name_of_lab, coordinates, minimalPoint, maxPersonalPoint, difficulty, author);
        HashMap<String, Labwork> hashMap = new HashMap<>();
        hashMap.put(key, lab);
        return hashMap;
    }

    static void show(HashMap<String, Labwork> hashMap) {
        TreeMap<String, Labwork> answer = sort_by_key(hashMap);
        for (Map.Entry<String, Labwork> entry : answer.entrySet())
            System.out.println("Ключ = " + entry.getKey() +
                    ", Значение = " + entry.getValue());
    }

    static void update(HashMap<String, Labwork> hashMap, Integer id) {
        String key = "";
        for (Map.Entry<String, Labwork> entry : hashMap.entrySet()) {
            Labwork lab = entry.getValue();
            Integer lab_id = lab.get_id();
            if (id.equals(lab_id)) {
                key = entry.getKey();
                hashMap.putAll(insert(key));
                hashMap.get(key).set_id(id);
                break;
            }else continue;
        }
        if(key.isEmpty())System.out.println("Элемент с id " + id + " не был найден");
    }

    static void remove(HashMap<String, Labwork> hashMap, String key) {
        hashMap.remove(key);
    }

    static void clear(HashMap<String, Labwork> hashmap) {
        hashmap.clear();
    }

    static Double average_of_personal_qualities_maximum(HashMap<String, Labwork> hashmap) {
        int count = 0;
        Double personalQualitiesMaximum = 0.0;
        for (Map.Entry<String, Labwork> entry : hashmap.entrySet()) {
            Labwork lab = entry.getValue();
            personalQualitiesMaximum += lab.get_personalQualitiesMaximum();
            count += 1;
        }
        return personalQualitiesMaximum / count;
    }

    static int count_by_minimal_point(HashMap<String, Labwork> hashmap, Integer minimalPoint) {
        int count = 0;
        for (Map.Entry<String, Labwork> entry : hashmap.entrySet()) {
            Labwork lab = entry.getValue();
            Integer lab_min = lab.get_minimalPoint();
            if (minimalPoint.equals(lab_min)) {
                count += 1;
            }
        }
        return count;
    }

    static LinkedHashSet<Double> get_unique_personal_qualities_maximum(HashMap<String, Labwork> hashMap) {
        LinkedHashSet<Double> linkedQualitiesSet = new LinkedHashSet<>();
        for (Map.Entry<String, Labwork> entry : hashMap.entrySet()) {
            Labwork lab = entry.getValue();
            linkedQualitiesSet.add(lab.get_personalQualitiesMaximum());
        }
        return linkedQualitiesSet;
    }

    //Cортировка коллекции по ключу
    static TreeMap<String, Labwork> sort_by_key(HashMap<String, Labwork> hashMap) {
        return new TreeMap<>(hashMap);
    }

    static String remove_lower(HashMap<String, Labwork> hashmap, String key) {
        for (Map.Entry<String, Labwork> entry : hashmap.entrySet()) {
            String sub_key = entry.getKey();
            Labwork lab = entry.getValue();
            if (lab.compareTo(hashmap.get(key)) < 0) {
                return sub_key;
            }
        }
        return null;
    }

    static void replace_if_greater(String key, HashMap<String, Labwork> hashMap) {
        HashMap<String, Labwork> help_hash;
        help_hash = insert(key);
        if (hashMap.get(key).compareTo(help_hash.get(key)) < 0) {
            hashMap.putAll(help_hash);
        }
    }

    static String remove_greater_key(String key, HashMap<String , Labwork> hashMap){
        for (Map.Entry<String, Labwork> entry : hashMap.entrySet()){
            String sub_key = entry.getKey();
            if(sub_key.compareTo(key)<0) return sub_key;
        }
        return null;
    }

    static void help() {
        System.out.println(
                "help : " +
                       "    • help : вывести справку по доступным командам\n" +
                        "    • info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "    • show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "    • insert null {element} : добавить новый элемент с заданным ключом\n" +
                        "    • update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "    • remove_key null : удалить элемент из коллекции по его ключу\n" +
                        "    • clear : очистить коллекцию\n" +
                        "    • save : сохранить коллекцию в файл\n" +
                        "    • execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "    • exit : завершить программу (без сохранения в файл)\n" +
                        "    • remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "    • replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого\n" +
                        "    • remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                        "    • average_of_personal_qualities_maximum : вывести среднее значение поля personalQualitiesMaximum для всех элементов коллекции\n" +
                        "    • count_by_minimal_point minimalPoint : вывести количество элементов, значение поля minimalPoint которых равно заданному\n" +
                        "    • print_unique_personal_qualities_maximum : вывести уникальные значения поля personalQualitiesMaximum всех элементов в коллекции");
    }

    static void info(HashMap<String, Labwork> hashMap, LocalDateTime time) {
        System.out.println("Тип: HashMap<String, Labwork> \n" +
                "Дата инициализации: "+ time + '\n' +
                "Количество элементов: " + hashMap.size() + '\n' +
                "Ключи: "
        );
        for(String key: hashMap.keySet()){
            System.out.print(key + "    ");
        }
        System.out.println();
    }

    //Метод, который реализует switch
    public static void choose(String answer, String file_name, LocalDateTime time, HashMap<String, Labwork> hashMap){
        String [] subAnswer = answer.split(" ");

        switch (subAnswer[0]) {
            case ("insert"):
                try {
                    hashMap.putAll(insert(subAnswer[1]));
                    break;
                }catch(Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }
            case("exit"):
                System.out.println("До свидания!");
                System.exit(0);
                break;
            case("show"):
                Commands.show(hashMap);
                break;
            case("update"):
                try {
                    int id_2 = Integer.parseInt(subAnswer[1]);
                    Commands.update(hashMap, id_2);
                    break;
                }catch (Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }

            case("remove"):
                try {
                    Commands.remove(hashMap, subAnswer[1]);
                    break;
                }catch(Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }
            case("clear"):
                Commands.clear(hashMap);
                break;
            case("average_of_personal_qualities_maximum"):
                Double average_of_personalQualitiesMaximum = Commands.average_of_personal_qualities_maximum(hashMap);
                System.out.println(average_of_personalQualitiesMaximum);
                break;
            case("count_by_minimal_point"):
                try {
                    int minimalPoint = Commands.count_by_minimal_point(hashMap, Integer.parseInt(subAnswer[1]));
                    System.out.println(minimalPoint);
                    break;
                }catch(Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }
            case("print_unique_personal_qualities_maximum"):
                LinkedHashSet<Double> linkedQualitiesSet = Commands.get_unique_personal_qualities_maximum(hashMap);
                System.out.println(linkedQualitiesSet);
                break;
            case("remove_lower"):
                try {
                    String key = Commands.remove_lower(hashMap, subAnswer[1]);
                    hashMap.remove(key);
                    break;
                }catch (Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }
            case("replace_if_greater"):
                try {
                    Commands.replace_if_greater(subAnswer[1], hashMap);
                    break;
                }catch(Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }
            case("remove_greater_key"):
                try {
                    String remove_key = Commands.remove_greater_key(subAnswer[1], hashMap);
                    hashMap.remove(remove_key);
                    break;
                }catch(Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }
            case("save"):
                Filework.save(file_name, hashMap);
                break;
            case ("help"):
                Commands.help();
                break;
            case("info"):
                Commands.info(hashMap, time);
                break;
            case("execute_script"):
                try{
                    Filework.execute_script(subAnswer[1],hashMap, file_name, time );
                    break;
                }catch (Exception e){
                    System.out.println("Неправильно введена команда");
                    break;
                }

            default:
                System.out.println("Такой команды не существует, попробуйте еще раз!");

        }
    }
}

