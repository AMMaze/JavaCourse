package Lesson_3.UniqueWords;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueWords {

    static public void main (String args[]) {
        RandomWords randomWords = new RandomWords(1, 5, false, false);
        String[] test = randomWords.getArray(20);
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



}
