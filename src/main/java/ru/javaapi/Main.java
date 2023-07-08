package ru.javaapi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Laptop> laptopList = createList();
        HashSet<String> resultList = new HashSet<>();
        Map<Integer, String> searchCriteria = createMapCriteria();
        System.out.println("Критерии поиска: " + searchCriteria);
        System.out.println("Для пропуска числовых фильтров укажите 0");
        System.out.println("Для пропуска строковых фильтров нажмите Enter");
        System.out.println();
        ArrayList<Object> array = getArrayFilter(scanner, searchCriteria);
        for (Laptop laptop : laptopList) {
            if (laptop.getRating() >= (double) array.get(1) &&
                    (laptop.getManufacturer().toLowerCase().contains((String) array.get(2))) &&
                    (laptop.getScreenDiagonal() >= (double) array.get(3)) &&
                    (laptop.getColor().toLowerCase().contains((String) array.get(4))) &&
                    (laptop.getPrice() >= (double) array.get(5))) {
                resultList.add(laptop.getName());
            }
        }
        System.out.println("resultList = " + resultList);
    }

    private static ArrayList<Object> getArrayFilter(Scanner scanner, Map<Integer, String> searchCriteria) {
        ArrayList<Object> array = new ArrayList<>();
        array.add(null);
        for (int i = 1; i <= searchCriteria.size(); i++) {
            if (i % 2 != 0) {
                System.out.println("Введите min значение для " + i + " критерия '" + searchCriteria.get(i) + "': ");
                array.add(scanner.nextDouble());
            } else {
                System.out.println("Введите строку значения для " + i + " критерия '" + searchCriteria.get(i) + "': ");
                scanner.nextLine();
                array.add(scanner.nextLine().toLowerCase());
            }
        }
        return array;
    }

    private static Map<Integer, String> createMapCriteria() {
        Map<Integer, String> searchCriteria = new HashMap<>();
        searchCriteria.put(1, "Рейтинг");
        searchCriteria.put(2, "Производитель");
        searchCriteria.put(3, "Размер диагонали экрана");
        searchCriteria.put(4, "Цвет");
        searchCriteria.put(5, "Цена");
        return searchCriteria;
    }

    private static ArrayList<Laptop> createList() {
        ArrayList<Laptop> resultList = new ArrayList<>();
        Laptop laptop1 = new Laptop("IdeaPad Gaming 3 15IHU6", 5.0, "LENOVO", 15.6, "Black", 73000.00);
        Laptop laptop2 = new Laptop("TUF Gaming F15 FX506LHB-HN324", 4.6, "ASUS", 15.6, "Black", 73000.00);
        Laptop laptop3 = new Laptop("Nitro 5 AN515-57-54VT", 4.6, "ACER", 15.6, "Black", 90000.00);
        Laptop laptop4 = new Laptop("ROG Strix G15 G513IE-HN004", 4.8, "ASUS", 15.6, "Gray", 105000.00);
        Laptop laptop5 = new Laptop("Aspire 5 A515-45-R2YG", 4.2, "ACER", 15.6, "Black", 55000.00);
        Laptop laptop6 = new Laptop("250 G8", 4.4, "HP", 15.6, "Black", 59000.00);
        Laptop laptop7 = new Laptop("ENVY 13-ba0000ur", 3.7, "HP", 13.3, "Silver", 60000.00);
        Laptop laptop8 = new Laptop("15s-eq2064ua", 4.8, "HP", 15.6, "Silver", 40000.00);
        Laptop laptop9 = new Laptop("IdeaPad 3 15IIL05", 4.7, "LENOVO", 15.6, "Gray", 73000.00);
        Laptop laptop10 = new Laptop("Complex Pro 17", 4.9, "2E", 17.3, "Black", 155000.00);
        resultList.add(laptop1);
        resultList.add(laptop2);
        resultList.add(laptop3);
        resultList.add(laptop4);
        resultList.add(laptop5);
        resultList.add(laptop6);
        resultList.add(laptop7);
        resultList.add(laptop8);
        resultList.add(laptop9);
        resultList.add(laptop10);
        return resultList;
    }
}
