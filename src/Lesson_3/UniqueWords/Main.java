package Lesson_3.UniqueWords;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    static public void main (String args[]) {
        String[] test = stringsArray(20, 5);
        System.out.println(Arrays.toString(test));

        printUnique(test);
    }

    static void printUnique (String[] strings) {
        Map<String, Integer> words = new HashMap<>();
        int max = 0;
        for(String it : strings) {
            max = it.length() > max ? it.length() : max;
            words.merge(it, 1, Integer::sum);
        }
        for(Map.Entry<String, Integer> it : words.entrySet()) {
            System.out.printf("%-" + max + "s - %d\n", it.getKey(), it.getValue());
        }
    }

    static String[] stringsArray(int size, int upperLen) {
        Random random = new Random();
        int same = random.nextInt(size);
        String[] array = new String[size];
        array[0] = randomString(random.nextInt(upperLen) + 1);
        for (int i = 1; i < size; i++) {
            if (random.nextInt(2) != 0 && same != 0) {
                array[i] = array[random.nextInt(i)];
                same--;
            } else {
                array[i] = randomString(random.nextInt(upperLen) + 1);
            }
        }

        return array;
    }

    static String randomString (int length) {
        Random random = new Random();
        StringBuilder string = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            string.append((char)('a' + random.nextInt('z' - 'a')));
        }
        return string.toString();
    }

}
