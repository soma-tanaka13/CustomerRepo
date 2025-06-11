package practice;

import java.util.Scanner;

public class GolfApp {
    public static void main(String[] args) {
        GolfGame game = new GolfGame();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("選手名2つ + スコア36個（カンマ区切り）で入力：");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("入力が空です。再入力してください。");
                continue;
            }

            if (!input.matches("[a-zA-Z0-9, ]+")) {
                System.out.println("無効な文字が含まれています。英数字・カンマ・スペースのみ使用可能です。");
                continue;
            }

            if (!game.inputGameData(input)) {
                System.out.println("フォーマットが正しくありません。選手名2つ + スコア36個をカンマ区切りで入力してください。");
                continue;
            }

            game.printResult();
            break;
        }

        sc.close();
    }
}
