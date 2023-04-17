package lesson1;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
        //ex4();
        ex5();
    }

    private static void ex1() {
        System.out.println("Введите ваше имя: ");
        Scanner iScaner = new Scanner(System.in);
        String name = iScaner.nextLine();
        System.out.printf("Привет, %s%n", name);
    }

    private static void ex2() {
        int[] arr = new int[]{0, 0, 1, 0, 1, 1, 1, 1, 1,};
        int count = 0;
        int maxValue = 0;
        for (int i : arr) {
            if (i == 1) count++;
            else {
                if (count > maxValue) {
                    maxValue = count;
                    count = 0;
                }
            }
        }
        if (count > maxValue) maxValue = count;
        System.out.println(maxValue);
    }

    private static void ex3() {
        int[] nums = new int[]{3, 2, 3, 2, 3}; // {
        int val = 3;
        int temp = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1; j++)
                if (nums[j] == val) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void ex4() {
        String str = "Добро пожаловать";
        String reversedString = new StringBuffer(str).reverse().toString();
        System.out.println(reversedString);
    }

    private static void ex5() {
        {
            try (FileWriter writer = new FileWriter("notes3.txt", false)) {
                // запись всей строки
                String text = "Hello Gold!";
                writer.write(text + "3\n");
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
