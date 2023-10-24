package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pitcher {
    private List<Integer> numbers;
    private int maxSize;

    public Pitcher(int maxSize) {
        this.numbers = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void getPlayerInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        Stack<Integer> split = new Stack<>();
        String inputStr = Console.readLine();

        if (inputStr.length() > maxSize) {
            throw new IllegalArgumentException("최대 길이 " + maxSize + "를 넘어가는 입력입니다.");
        }

        int inputNumber = Integer.parseInt(inputStr);
        splitNumbers(split, inputNumber);
        updateNumbers(split);
    }

    public void splitNumbers(Stack<Integer> split, int number) throws IllegalArgumentException {
        while (number != 0) {
            int digit = number % 10;
            if (split.contains(digit)) {
                throw new IllegalArgumentException("서로 다른 수를 입력 해야 합니다.");
            }
            split.push(digit);
            number /= 10;
        }
    }

    public void updateNumbers(Stack<Integer> split) {
        numbers.clear();
        while (numbers.size() < maxSize) {
            numbers.add(split.pop());
        }
    }
}