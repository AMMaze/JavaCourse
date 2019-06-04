package Lesson_1.Marafon.Competitors;

import java.util.ArrayList;

public class Team {
    private ArrayList<Competitor> competitors;
    private String name;

    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = new ArrayList<Competitor>();
        for (Competitor it : competitors) {
            this.competitors.add(it);
        }
    }

    public void showResults() {
        for (Competitor it : competitors) {
            it.info();
        }
    }

    public void showWinners() {
        for (Competitor it: competitors) {
            if (it.isOnDistance()) {
                it.info();
            }
        }
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }
}
