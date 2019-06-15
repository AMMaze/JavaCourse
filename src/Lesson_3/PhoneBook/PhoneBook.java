package Lesson_3.PhoneBook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    Map<String, HashSet<String>> book;

    public PhoneBook() {
        book = new HashMap<String, HashSet<String>>();
    }

    public void add(String name, String number) {
        HashSet<String> phones = book.get(name);
        if (phones == null) {
            phones = new HashSet<>();
            book.put(name, phones);
        }
        phones.add(number);
    }

    public void get(String name) {
        HashSet<String> phones = book.get(name);
        System.out.println(name + ":");
        for (String it : phones) {
            System.out.println("    " + it);
        }
    }

    public void getAll() {
        for (String it : book.keySet()) {
            this.get(it);
        }
    }

}
