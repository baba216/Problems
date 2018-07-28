package leetCodeRandom.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String result = process(num, k);
        System.out.println(result);
    }

    private static String process(String num, int k) {
        int pointer = 0;
        Stack<Character> numberToCare = new Stack<>();
        Queue<Character> numberToConsider = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            numberToConsider.offer(num.charAt(i));
        }
        while (k != 0 && !numberToConsider.isEmpty()) {
            Character numToInsert = numberToConsider.poll();
            // put a check for the size of string
            if (numberToCare.isEmpty()) {
                numberToCare.push(numToInsert);
                continue;
            }
            if (numToInsert > numberToCare.peek()) {
                numberToCare.push(numToInsert);
                continue;
            }
            while (!numberToCare.isEmpty() && numToInsert < numberToCare.peek()) {
                k--;
                numberToCare.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while (!numberToCare.isEmpty()) {
            result.insert(0, numberToCare.pop());
        }
        while (!numberToConsider.isEmpty()) {
            result.append(numberToConsider.poll());
        }
        return result.toString();
    }
}
