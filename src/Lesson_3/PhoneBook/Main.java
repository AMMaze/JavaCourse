package Lesson_3.PhoneBook;

import Lesson_3.UniqueWords.RandomWords;

import java.util.Arrays;

public class Main {

    static public void main (String args[]) {
        RandomWords randomNames = new RandomWords(3, 6, false, false);
        RandomWords randomPhones = new RandomWords(11, 11, false, true);
        String[] names = randomNames.getArray(20);
        String[] numbers = randomPhones.getArray(20);
        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(numbers));
        PhoneBook phoneBook = new PhoneBook();
        for (int i = 0; i < names.length; i++) {
            phoneBook.add(names[i], numbers[i]);
        }

        phoneBook.getAll();
    }

}
