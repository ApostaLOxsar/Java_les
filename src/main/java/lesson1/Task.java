package lesson1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
        //ex4();
        //ex5();
        //Les1_HW-------------------------------------------
        //task1HW();
        //task2HW();
        //task3HW();
        //task4HW();
        task5HW();
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
                writer.write(text + "1\n");
                writer.write(text + "2\n");
                writer.write(text + "3\n");
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }

    }



    //Les1_HW--------------------------------------
    //Task1
    private static void task1HW() {
        Scanner iScaner = new Scanner(System.in);
        int len = 0;
        int initialValue = 0;

        System.out.print("Введите len: ");
        if (iScaner.hasNextInt()) {
            len = iScaner.nextInt();

            System.out.print("Введите initialValue: ");
            if (iScaner.hasNextInt()) {
                initialValue = iScaner.nextInt();

                int[] arr = GetArray(len, initialValue);
                System.out.println(Arrays.toString(arr));
            } else {
                System.out.println("Вы ввели явно не initialValue :( \nВсе сначало");
                task1HW();
            }
        } else {
            System.out.println("Вы ввели явно не len :( \nВсе сначало");
            task1HW();
        }
    }

    private static int[] GetArray(int lens, int value) {
        //В задаче указано написать метод
        int[] result = new int[lens];
        Arrays.fill(result, value);
        return result;
    }


    //task2
    private static void task2HW() {
        Scanner iScaner = new Scanner(System.in);
        int lens = 0; //как можно этого избежать или это не критично?

        System.out.print("Введите длинну массива: ");
        if (iScaner.hasNextInt()) {
            lens = iScaner.nextInt();
        } else {
            System.out.println("Вы ввели явно не длинну массива :( \nВсе сначало");
            task2HW();
        }

        int[] arr = new int[lens];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));

        int minInArr = arr[0];
        int maxInArr = arr[0];

        for (int i : arr) {
            if (minInArr > i) {
                minInArr = i;
            } else if (maxInArr < i) {
                maxInArr = i;
            }
        }
        System.out.printf("Минимальное в массиве = %d\n", minInArr);
        System.out.printf("Максимальное в массиве = %d", maxInArr);
    }


    //task3
    private static void task3HW() {
        Scanner iScaner = new Scanner(System.in);
        int arrSize = 0;

        System.out.print("Введите размерность массива: ");
        if (iScaner.hasNextInt()) {
            arrSize = iScaner.nextInt();
        } else {
            System.out.println("Вы ввели явно не длинну массива :( \nВсе сначало");
            task3HW();
        }
        int[][] arr = new int[arrSize][arrSize];

        for (int i = 0; i <= arr.length / 2; i++) {
            arr[i][i] = 1;
            arr[arr.length - i - 1][i] = 1;
            arr[i][arr.length - i - 1] = 1;
            arr[arr.length - i - 1][arr.length - i - 1] = 1;
        }

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", " "));
        }

    }


    //task4
    private static void task4HW() {
        Scanner iScaner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = iScaner.nextLine();

        GregorianCalendar calendar = new GregorianCalendar();
        int time = calendar.get(Calendar.HOUR_OF_DAY);

        if (time >= 5 && time < 12){
            System.out.printf("Доброе утро, %s", name);
        } else if (time >= 12 && time < 18) {
            System.out.printf("Добрый день, %s", name);
        } else if (time >=18 && time < 23) {
            System.out.printf("Добрый вечер, %s", name);
        } else {
            System.out.printf("Доброй ночи, %s", name);
        }
    }


    //task5
    private static void task5HW() {
        Scanner iScaner = new Scanner(System.in);
        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        System.out.print("Введите сдвиг ");
        if (iScaner.hasNextInt()) {
            int shift = iScaner.nextInt();
        } else {
            System.out.println("Вы ввели явно не сдвиг :( \nВсе сначало");
            task5HW();
        }
        System.out.println(Arrays.toString(arr));


    }
}
