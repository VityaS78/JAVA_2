package lesson_3.HW_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    private HashMap<String, HashSet<Integer>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, int phoneNumber) {
        if (phoneBook.get(name) == null) phoneBook.put(name, new HashSet<>(Arrays.asList(phoneNumber)));
        else phoneBook.get(name).add(phoneNumber);
        System.out.println("Контакт добавлен в телефонную книгу");
        System.out.println();

    }

    public void get(String name) {
        System.out.println("Номер абонента " + name + ":");
        for (Integer num : phoneBook.get(name)) System.out.println(num);
        System.out.println();
    }
}
