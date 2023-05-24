package Lesson6;

import java.util.HashMap;
import java.util.Map;

import static Lesson6.Logic.*;

public class LaptopInterfec {
    public static void main(String[] args) {
        Map<Integer, Object> nout = new HashMap<>();
        catalogNout(nout);
        interfece(nout);
    }


    public static void interfece(Map<Integer, Object> nout) {
        int flag = 0;
        System.out.println("Введите что вы хотите сделать?");
        System.out.println("1 - Просмотр каталога");
        System.out.println("2 - Добавить в каталог ноутбук");
        System.out.println("3 - Отфильтровать и вывести на экран");
        System.out.println("Любые другие цифры - Выход");
        int input = inputInt();

        switch (input) {
            case 1 -> printNout(nout);
            case 2 -> nout = inputLaptop(nout);
            case 3 -> Filter(nout);
            default -> flag = -1;
        }
        if (flag != -1) {
            interfece(nout);
        }
    }
}





