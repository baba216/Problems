package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-88/problems/maximize-distance-to-closest-person/
public class MaximizeDistanceClosestPerson {

    public static void main(String[] args) {
        //int[] seats = {1, 0, 0, 0, 1, 0, 1};
        //int[] seats = {1, 0, 0, 0};
        //int[] seats = {1,0,0,0,1};
        //int[] seats = {0,1};
        //int[] seats = {0};
        int[] seats = {0,0,1};
        //int result = process(seats);
        int result = bestApproach(seats);
        System.out.println(result);
    }

    private static int bestApproach(int[] seats) {
        int continuousEmptySeats = 0;
        int maxDistance = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                continuousEmptySeats++;
                maxDistance = Math.max(maxDistance, (continuousEmptySeats + continuousEmptySeats % 2) / 2);
            }else {
                continuousEmptySeats = 0;
            }
        }
        return Math.max(maxDistance,continuousEmptySeats);
    }

    private static int process(int[] seats) {
        int[] maxDistance = new int[seats.length];
        maxDistance[0] = Integer.MAX_VALUE;
        int distFromLeft = 0;
        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 0) {
                maxDistance[i] = ++distFromLeft;
            } else {
                distFromLeft = 0;
            }
        }
        int maxDist = maxDistance[seats.length - 1];
        int disFromRight = 0;
        for (int i = seats.length - 2; i >= 0; i--) {
            if (seats[i] == 0) {
                maxDistance[i] = Math.min(maxDistance[i], ++disFromRight);
                maxDist = Math.max(maxDist, maxDistance[i]);
            } else {
                disFromRight = 0;
            }
        }
        return maxDist;
    }
}
