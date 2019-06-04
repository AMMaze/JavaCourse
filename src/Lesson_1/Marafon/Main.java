package Lesson_1.Marafon;

import Lesson_1.Marafon.Competitors.*;
import Lesson_1.Marafon.Course.Course;
import Lesson_1.Marafon.Course.Cross;
import Lesson_1.Marafon.Course.Obstacle;
import Lesson_1.Marafon.Course.Wall;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Имя_команды", new Human("Боб"),
                new Cat("Барсик"), new Dog("Бобик"));
        Course course = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120));
        course.doIt(team);
        team.showResults();
    }
}