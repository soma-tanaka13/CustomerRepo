package practice;

import java.util.ArrayList;
import java.util.List;

public class GolfGame {
    private final int[] par = {4,4,3,4,5,4,5,3,4,4,3,4,5,4,3,4,5,4};
    private Player player1;
    private Player player2;

    public boolean inputGameData(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != 38) {
            return false;
        }

        String name1 = tokens[0].trim();
        String name2 = tokens[1].trim();
        List<Integer> scores = new ArrayList<>();

        for (int i = 2; i < 38; i++) {
            try {
                int score = Integer.parseInt(tokens[i].trim());
                if (score <= 0) return false;
                scores.add(score);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        List<Integer> scores1 = scores.subList(0, 18);
        List<Integer> scores2 = scores.subList(18, 36);

        player1 = new Player(name1, scores1);
        player2 = new Player(name2, scores2);
        return true;
    }

    public void printResult() {
        int score1 = player1.calculateScore(par);
        int score2 = player2.calculateScore(par);

        System.out.println(player1.getName() + " のスコア：" + score1);
        System.out.println(player2.getName() + " のスコア：" + score2);

        if (score1 < score2) {
            System.out.println("勝者: " + player1.getName());
        } else if (score1 > score2) {
            System.out.println("勝者: " + player2.getName());
        } else {
            System.out.println("引き分けです。");
        }
    }
}
