package Lesson2;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class task {
    public static void main(String[] args) {
        //System.out.println(zipString("aaabbdfffe"));
        //HW2-----------------------------------
        task1();
        task2();
    }

    private static void task2() {
        String catalog = "C:\\Users\\user\\Desktop\\Java\\.idea";
        catalog = ".";
        File dir = new File(catalog);
        File[] test = dir.listFiles();
        for (File temp: test){
            if (!temp.isDirectory()){
                String[] nameFile = temp.getName().split("\\.");
                System.out.println("Расширение файла: " + nameFile[1]);
            }
        }
    }

    private static void task1() {

        String jsonInput = "{name:Ivanov, country:Russia, city:Moscow, age:null}";
        String[] jsonArrInput = jsonInput.replaceAll("[\\{\\}\\ ]", "").split(",");
        Map<String, String> json = new HashMap<>();

        for (String str : jsonArrInput) {
            String[] temp = str.split(":");
            json.put(temp[0], temp[1]);
        }

        String caption = "SELECT * FROM USER ";
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (String key : json.keySet()) {
            String temp1 = json.get(key);
            String temp2 = "null";
            //в чем отличие (!"null".equals(json.get(key))) от (!Object.equals("null", json.get(key))
            if (!Objects.equals("null", json.get(key))) {
                if (!first) {
                    result.append(" and ");
                }
                result.append(key + "=" + json.get(key));
                first = false;
            }
        }
        if (!first) {
            result.insert(0, "WHERE \n");
        }
        System.out.println(caption + result.toString());
    }


    public static String zipString(String inputStr) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < inputStr.length(); i++) {

            char currentChar = inputStr.charAt(i - 1);
            if (inputStr.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(currentChar);
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            }
            if (i == inputStr.length() - 1) {
                result.append(inputStr.charAt(i));
                if (count > 1) {
                    result.append(count);
                }
            }
        }
        return result.toString();
    }

}

