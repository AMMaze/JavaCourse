package Lesson_2;

public class Main {

    public static void main(String args[]) {
        String[][] array = {{"1", "12", "5", "1"},
                            {"1d", "7", "1", "1"},
                            {"1", "2", "3", "4"},
                            {"1", "2", "3", "4"}};
        try {
            System.out.println(sumStringArr(array));
        } catch (MyArraySizeException e) {
            System.out.println("Incorrect array size");
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


    }


    static int sumStringArr (String numbers[][]) throws MyArraySizeException, MyArrayDataException {
        if (numbers.length != 4) {
            throw new MyArraySizeException();
        }

        int res = 0;

        for (int i = 0; i < 4; i++) {
            if (numbers[i].length != 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < 4; j++) {
                try {
                    res += Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return res;
    }
}
