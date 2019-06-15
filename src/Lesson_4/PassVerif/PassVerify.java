package Lesson_4.PassVerif;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassVerify {

    static public void main (String args[]) {
        String pass = "123r%wGG";

        System.out.println(match(pass));
    }

    static public boolean match (String pass) {
        Pattern p = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*\\W)[a-zA-Z0-9\\W]{8}$");
        Matcher m = p.matcher(pass);

        return m.matches();
    }

}
