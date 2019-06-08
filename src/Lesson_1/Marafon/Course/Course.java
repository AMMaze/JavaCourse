package Lesson_1.Marafon.Course;

import Lesson_1.Marafon.Competitors.Competitor;
import Lesson_1.Marafon.Competitors.Team;

import java.util.ArrayList;

public class Course {
    private ArrayList<Obstacle> obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = new ArrayList<>();
        for(Obstacle it : obstacles) {
            this.obstacles.add(it);
        }
    }

    public void doIt (Team team) {
        for (Competitor comp : team.getCompetitors()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(comp);
                if (!comp.isOnDistance()) break;
            }
        }
    }

}
