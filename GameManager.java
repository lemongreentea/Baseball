import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private final ArrayList<Integer> records = new ArrayList<>();
    private int number = 3;

    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정  1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
            String menuChoice = sc.next();

            switch (menuChoice) {
                case "0":
                    setDifficulty(sc);
                    break;
                case "1":
                    startGame();
                    break;
                case "2":
                    showRecords();
                    break;
                case "3":
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;
                default:
                    System.out.println("올바르지 않은 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    private void setDifficulty(Scanner sc) {
        System.out.println("설정하고자 하는 자리수를 입력하세요. (3, 4, 5)");
        number = Integer.parseInt(sc.next());

        if (number < 3 || number > 5) {
            System.out.println("잘못된 입력값입니다.");
            number = 3;
        } else {
            System.out.println(number + "자리수 난이도로 설정되었습니다.");
        }
    }

    private void startGame() throws Exception {
        BaseballGame baseballGame = new BaseballGame(new RandoAnswerGenerator(), number);
        int attempts = baseballGame.play();
        records.add(attempts);
        System.out.println("게임 횟수는 " + attempts + "번 입니다.");
    }

    private void showRecords() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + records.get(i));
        }
    }

}
