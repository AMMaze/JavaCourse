package Lesson_1.Marafon;

import Lesson_1.Marafon.Competitors.Cat;
import Lesson_1.Marafon.Competitors.Competitor;
import Lesson_1.Marafon.Competitors.Dog;
import Lesson_1.Marafon.Competitors.Human;
import Lesson_1.Marafon.Course.Cross;
import Lesson_1.Marafon.Course.Obstacle;
import Lesson_1.Marafon.Course.Wall;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
        for (Competitor c : competitors) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
        for (Competitor c : competitors) {
            c.info();
        }
    }
}