import java.util.HashSet;
import java.util.Random;

public class RandoAnswerGenerator implements AnswerGenerator {

    @Override
    public int[] generateAnswer(int number) {
        HashSet<Integer> set = new HashSet<>();
        Random rand = new Random();
        int[] answer = new int[number];

        while (set.size() < number) {
            set.add(rand.nextInt(9) + 1);
        }

        int index = 0;
        for (int num : set) {
            answer[index++] = num;
        }

        return answer;
    }
}
