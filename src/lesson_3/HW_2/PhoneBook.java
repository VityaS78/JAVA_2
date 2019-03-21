package lesson_3.HW_2;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    HashMap<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public PhoneBook() {
//        HashMap<String, HashSet<Integer>> phoneBook= new HashMap<>();
    }

    public void add(String name, int phoneNumber) {
        HashSet<Integer> number = new HashSet<>();
        if (phoneBook.get(name) == null) {
            number.add(phoneNumber);
            phoneBook.put(name, number);
        } else {
            number = phoneBook.get(name);
            number.add(phoneNumber);
            phoneBook.put(name, number);
        }
        System.out.println("Контакт добавлен в телефонную книгу");
        System.out.println();
    }

    public void get(String name) {
        HashSet<Integer> number = new HashSet<>();
        number = phoneBook.get(name);
        System.out.println("Номер абонента " + name + ":");
        for (Integer num : number) {
            System.out.println(num);
        }
        System.out.println();
    }
}
