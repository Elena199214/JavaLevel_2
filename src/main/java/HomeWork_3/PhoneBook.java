package HomeWork_3;

import java.util.*;

public class PhoneBook {

    Map<String, List<String>> pBook = new TreeMap<>();

    // Добавляем значения в телефонную книгу
    public void add(String name, String number) {
        if (pBook.containsKey(name)) {
            pBook.get(name).add(number);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(number);
            pBook.put(name, phoneNumbers);
        }
    }

    // Получаем значения из телефонной книги
    public List<String> get(String name) {
        if (pBook.containsKey(name)) {
            System.out.println(name + " " + pBook.get(name));
        } else {
            System.out.println(name + " нет в телефонной книге!");
        }
        return Collections.emptyList();
    }

}
