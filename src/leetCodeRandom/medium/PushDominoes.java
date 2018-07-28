package leetCodeRandom.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-85/problems/push-dominoes/
public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        String output = process(dominoes);
        System.out.println(output);
    }

    private static String process(String dominoes) {
        Deque<Character> store = new LinkedList<>();
        StringBuilder result = new StringBuilder(dominoes.length());
        int globalPointer = 0;
        int lPointer = Integer.MIN_VALUE;
        int rPointer = Integer.MAX_VALUE;
        while (globalPointer < dominoes.length()) {
            char x = dominoes.charAt(globalPointer);
            if (x == '.') {
                store.offer(x);
                globalPointer++;
            }
            if (x == 'R') {
                int rPos = globalPointer;
                globalPointer++;
                while (globalPointer < dominoes.length() && dominoes.charAt(globalPointer) == '.') {
                    globalPointer++;
                }
                if (globalPointer != dominoes.length() && dominoes.charAt(globalPointer) == 'R') {
                    while (!store.isEmpty()) {
                        result.append('R');
                        store.poll();
                    }
                }
                if (globalPointer != dominoes.length() && dominoes.charAt(globalPointer) == 'L') {
                    int lPos = globalPointer;
                    while (rPos < lPos) {

                    }
                }
            }
        }
        return result.toString();
    }
}
