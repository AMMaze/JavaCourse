package Lesson_2;

public class MyArrayDataException extends Exception {

    int i, j;

    MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String getMessage() {
        return "Incorrect data at (" + i + ", " + j + ")";
    }

}
