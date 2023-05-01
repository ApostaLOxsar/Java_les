package Lesson4;

import java.util.*;

public class task {
    public static void main(String[] args) {
        //ex1();
        ex2();
    }

    private static void ex2() {
        List<String> temp = List.of("1", "2", "3", "4", "5", "6");
        List<String> inputArr = new LinkedList<>(temp);
        System.out.println(inputArr.toString().replaceAll("[\\[\\]\\,]",""));
        Collections.reverse(inputArr);
        System.out.println(inputArr.toString().replaceAll("[\\[\\]\\,]",""));
    }

    private static void ex1() {
        Scanner sc = new Scanner(System.in);
        List<String> arrString = new ArrayList<>();
        String temp;
        boolean flagStop = true;
        while (flagStop) {
            System.out.println("Введите элемент или print или revert");
            temp = sc.nextLine();
            if (temp.equals("print")) {
                flagStop = false;
            } else if (temp.equals("revert")) {
                arrString.remove(arrString.size() - 1);
            } else {
                arrString.add(temp);
            }
        }
        System.out.println(arrString.toString().replaceAll("[\\[\\]\\,]", ""));

    }
}
