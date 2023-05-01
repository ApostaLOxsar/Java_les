package les5;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task {
    public static void main(String[] args) {
        System.out.println(arabicToRoman(2999));
    }


    public static String arabicToRoman(int num) {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder resultBuilder = new StringBuilder();

        for (int key : map.keySet()) {
            while (num >= key) {
                resultBuilder.append(map.get(key));
                num -= key;
            }
        }

        return resultBuilder.toString();
    }
}
