package Lesson_3.UniqueWords;

import java.util.Random;

public class RandomWords {

    int lowerLen, upperLen;
    boolean unique, numbers;

    public RandomWords(int lowerLen, int upperLen, boolean unique, boolean numbers) {
        this.lowerLen = lowerLen;
        this.upperLen = upperLen;
        this.unique = unique;
        this.numbers = numbers;
    }


    public String[] getArray(int size) {
        Random random = new Random();
        int same = unique ? 0 : random.nextInt(size);
        String[] array = new String[size];
        array[0] = randomString(lowerLen + random.nextInt(upperLen - lowerLen + 1));
        for (int i = 1; i < size; i++) {
            if (random.nextInt(2) != 0 && same != 0) {
                array[i] = array[random.nextInt(i)];
                same--;
            } else {
                array[i] = randomString(lowerLen + random.nextInt(upperLen - lowerLen + 1));
            }
        }

        return array;
    }

    public String randomString (int length) {
        Random random = new Random();
        StringBuilder string = new StringBuilder(length);
        int start = numbers ? '0' : 'a';
        int span = numbers ? '9' - '0' : 'z' - 'a';
        for (int i = 0; i < length; i++) {
            string.append((char)(start + random.nextInt(span)));
        }
        return string.toString();
    }

    public void setLowerLen(int lowerLen) {
        this.lowerLen = lowerLen;
    }

    public void setUpperLen(int upperLen) {
        this.upperLen = upperLen;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }
}
