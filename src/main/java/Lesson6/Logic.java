package Lesson6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {

    }

    public static void catalogNout(Map<Integer, Object> nout) {
        var laptop1 = new Laptop();
        laptop1.name = "dell";
        laptop1.ram = 16;
        laptop1.sizeHdd = 1024;
        laptop1.nameOS = "Win8";
        laptop1.color = "green";

        var laptop2 = new Laptop();
        laptop2.name = "sams";
        laptop2.ram = 32;
        laptop2.sizeHdd = 1024;
        laptop2.nameOS = "Win10";
        laptop2.color = "yellow";

        var laptop3 = new Laptop();
        laptop3.name = "dell";
        laptop3.ram = 8;
        laptop3.sizeHdd = 512;
        laptop3.nameOS = "WinXP";
        laptop3.color = "black";

        nout.put(1, laptop1);
        nout.put(2, laptop2);
        nout.put(3, laptop3);
        //addNout("sony", 4,512,"MacOS","green", nout);
    }

    public static Map<Integer, Object> addNout(String name,
                                               Integer ram,
                                               Integer sizeHdd,
                                               String nameOS,
                                               String color, Map<Integer, Object> nout) {
        nout.put(nout.size() + 1, new Laptop());
        Laptop temp = (Laptop) nout.get(nout.size());
        temp.name = name;
        temp.ram = ram;
        temp.sizeHdd = sizeHdd;
        temp.nameOS = nameOS;
        temp.color = color;
        return nout;
    }

    public static void printNout(Map<Integer, Object> itemTemp) {
        for (Map.Entry<Integer, Object> item : itemTemp.entrySet()) {
            System.out.println(item.getKey().toString() + ": " + item.getValue());
        }
        System.out.println();
    }

    public static Map<Integer, Object> inputLaptop(Map<Integer, Object> nout) {
        Scanner iScaner = new Scanner(System.in);

        System.out.println("Введите название ноутбука");
        String name = iScaner.nextLine();

        System.out.println("Введите обьем оперативной памяти");
        int ram = inputInt();

        System.out.println("Введите обьем HDD");
        int sizeHdd = inputInt();

        System.out.println("Введите название OS");
        String nameOS = iScaner.nextLine();

        System.out.println("Введите цвет");
        String color = iScaner.nextLine();

        return addNout(name, ram, sizeHdd, nameOS, color, nout);
    }

    public static Integer inputInt() {
        int inputValue = -1;
        Scanner iScaner = new Scanner(System.in);
        do {
            try {
                String inputString = iScaner.nextLine();
                inputValue = Integer.parseInt(inputString);
            } catch (Exception e) {
                System.out.println("Данные не коректны попробуйте еще раз");
            }
        } while (inputValue == -1);

        return inputValue;
    }

    public static void Filter(Map<Integer, Object> nout) {
        System.out.println("выберете по чем будем сортировать?");
        System.out.println("1 - оперативная память");
        System.out.println("2 - размер HDD");
        int criteria = inputInt();
        Map<Integer, Object> filter = new HashMap<>();
        switch (criteria) {
            case 1 -> {
                System.out.println("Вы выбрали сортировку по оперативной памяти\nВведите минимальный размер");
                int minRAM = inputInt();
                for (Object items : nout.values()) {
                    Laptop item = (Laptop) items;
                    if (item.ram >= minRAM) {
                        filter.put(filter.size() + 1, item);
                    }
                }
                if (filter.size() > 0) {
                    System.out.println("Вот ноутбуки удолетворяющие вашим требованием");
                    printNout(filter);
                } else {
                    System.out.println("Таких нооутбуков нет\n");
                }
            }
            case 2 -> {
                System.out.println("Вы выбрали сортировку по HDD\nВведите минимальный размер");
                int minHdd = inputInt();
                for (Object items : nout.values()) {
                    Laptop item = (Laptop) items;
                    if (item.sizeHdd >= minHdd) {
                        filter.put(filter.size() + 1, item);
                    }
                }
                if (filter.size() > 0) {
                    System.out.println("Вот ноутбуки удолетворяющие вашим требованием");
                    printNout(filter);
                } else {
                    System.out.println("Таких нооутбуков нет\n");
                }
            }
            default -> {
                System.out.println("К сожалению вы ввели некоректные параметры давайте попробуем ее раз");
                Filter(nout);
            }
        }
    }
}
