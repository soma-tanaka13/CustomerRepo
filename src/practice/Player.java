package practice;

import java.util.List;

public class Player {
    private String name;
    private List<Integer> scores;

    public Player(String name, List<Integer> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int calculateScore(int[] par) {
        int total = 0;
        for (int i = 0; i < par.length && i < scores.size(); i++) {
            total += (scores.get(i) - par[i]);
        }
        return total;
    }
}

