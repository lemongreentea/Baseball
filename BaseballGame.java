import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    private final int[] answer;
    private final int number;
    private final BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();

    public BaseballGame(AnswerGenerator answerGenerator, int number) {
        this.answer = answerGenerator.generateAnswer(number);
        this.number = number;
    }

    public int play() throws Exception {
        int count = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("<게임을 시작합니다>");
        while (true) {
            System.out.println("정답:" + Arrays.toString(answer));
            System.out.println("숫자를 입력하세요");
            String input = sc.next();
            if (!validateInput(input)) {
                continue;
            }
            count++;
            int strike = countStrike(input);
            int ball = countBall(input) - strike;

            if (countStrike(input) == number) {
                System.out.println("축하합니다. 정답입니다.");
                break;
            } else {
                baseballGameDisplay.displayHint(strike, ball);
            }
        }
        return count;
    }

    protected boolean validateInput(String input) throws Exception {
        if (!input.matches("[0-9]+") || input.length() != number) {
            System.out.println("올바르지 않은 입력값입니다.");
            return false;
        }
        return true;
    }

    private int countStrike(String input) {
        int countStrike = 0;

        for (int i = 0; i < input.length(); i++) {
            if (answer[i] == Integer.parseInt(String.valueOf(input.charAt(i)))) {
                countStrike++;
            }
        }

        return countStrike;
    }

    private int countBall(String input) {
        int countBall = 0;
        for (int ball : answer) {
            if (input.contains(String.valueOf(ball))) {
                countBall++;
            }
        }

        return countBall;
    }
}
