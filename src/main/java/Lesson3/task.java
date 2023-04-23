package Lesson3;

import java.util.*;

public class task {
    public static void main(String[] args) {
        //ex1();
        //task1();
        task2();
    }

    private static void task2() {
        List<List<String>> booksArr = new ArrayList<>();
        Scanner iSc = new Scanner(System.in);
        //List<String> nameBooks = new ArrayList<>();

        while (true) {
            System.out.println("Введите название жанра:");
            String genreBook = iSc.next().toLowerCase();
            System.out.println("Введите название книг в конце законците 0:");
            StringBuilder nameBook = new StringBuilder();
            String tempNemeBook = "";

            while (!tempNemeBook.equals("0, ")) {
                nameBook.append(tempNemeBook);
                tempNemeBook = iSc.next().toLowerCase() + ", ";
            }

            AddBooks(nameBook, genreBook, booksArr);
            PrintCatalog(booksArr);

        }
    }

    private static void AddBooks(StringBuilder nameBook, String genreBook, List<List<String>> booksArr) {

        addGenre(genreBook, booksArr);

        for (List<String> tempBooksArr : booksArr) {
            if (tempBooksArr.get(0).equals(genreBook)) {
                tempBooksArr.addAll(Arrays.asList(nameBook.toString().split(", ")));
            }
        }

    }

    private static void addGenre(String genreBook, List<List<String>> booksArr) {
        for (List<String> tempBooksArr : booksArr) {
            /*
            Необработанное использование параметризованного класса «Список» что это значит простыми словами?
            вылечилост преобразованием 47-48 строки с List booksArr в List<List<String>> booksArr на 47
            и List tempBooksArr в List<String> tempBooksArr соотвецтвенно
            насколько это критично?
             */
            if (tempBooksArr.get(0).equals(genreBook)) {
                return;
            }
        }
        booksArr.add(new ArrayList<String>(Collections.singletonList(genreBook)));
        /*
        предлогает исправить на (Collections.singletonList(genreBook)) вместо (Arrays.asList(genreBook))
        но если я правильно понял то эти два метода создают НЕизменяемые списки (но код работает и даёт добавить элементы) как так?
         */
    }

    private static void PrintCatalog(List<List<String>> booksArr) {
        for (List<String> list : booksArr) {
            System.out.print(list.get(0) + " - ");
            System.out.println(list.subList(1, list.size()).toString().replaceAll("[\\[\\]]", ""));
            //так норм? я про длинную строку методов которые мне понятны а другим неизвестно
        }
    }

    //---------------------------------------------------
    private static void task1() {
        List<String> array = new ArrayList<>();
        GetArray(array, 5);
        System.out.println(array.toString());
        int i = 0;
        while (i < array.size()) {
            try {
                Integer.parseInt(array.get(i));
                array.remove(i);
            } catch (Exception e) {
                i++;
            }
        }
        System.out.println(array.toString());
    }

    public static void GetArray(List<String> inputArray, int k) {
        List<String> value = new ArrayList<>(Arrays.asList("1", "slovo"));
        Random rg = new Random();
        for (int i = 0; i < k; i++) {
            inputArray.add(value.get(rg.nextInt(2)));
        }
    }

    private static void ex1() {
        List<String> planets = new ArrayList<>();
        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Сатурн");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Земля");
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Юпитер");

        Set<String> uniquePlanets = new HashSet<>(planets);
        for (String planet : uniquePlanets) {
            int count = Collections.frequency(planets, planet);
            System.out.println(planet + ": " + count);
        }
    }


}
