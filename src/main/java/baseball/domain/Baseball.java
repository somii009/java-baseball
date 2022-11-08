package baseball.domain;

import java.util.stream.IntStream;

public class Baseball {
    private final Computer computer;
    //result[0]: 볼, result[1]: 스트라이크
    private int[] result = new int[2];

    public Baseball() {
        this.computer = new Computer();
    }

    public String getAnswer() {
        return computer.getAnswer();
    }

    public int[] getResult() {
        return result;
    }

    public void compareResult(String baseballNumber) {
        int contains = countContains(baseballNumber);
        int strikes = countStrike(baseballNumber);

        result[0] = contains - strikes;
        result[1] = strikes;
    }

    private int countContains(String baseballNumber) {
        String answer = getAnswer();

        return (int) baseballNumber.chars()
                .mapToObj(Character::toString)
                .filter(answer::contains)
                .count();
    }

    private int countStrike(String baseballNumber) {
        char[] answer = getAnswer().toCharArray();
        char[] input = baseballNumber.toCharArray();

        return (int) IntStream.range(0, 3)
                .filter(o -> answer[o] == input[o])
                .count();
    }

}
