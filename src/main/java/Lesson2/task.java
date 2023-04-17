package Lesson2;

public class task {
    public static void main(String[] args) {
        System.out.println(zipString("aaabbdfffe"));
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

