package algorithm.DP;

import java.util.Scanner;

public class back_2579 {
    static int N;
    static int[] stair;
    static int[] stairlog;
    static int s = 0;

    public back_2579() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        stair = new int[N];
        stairlog = new int[N];
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(sc.nextLine());
            stair[i] = M;
        }
        play();

        System.out.println(stairlog[N - 1]);
    }

    static void play() {
        if (N == 1) {
            stairlog[0] = stair[0];
        } else if (N == 2) {
            stairlog[0] = stair[0];
            stairlog[1] = stair[0] + stair[1];
        } else {
            stairlog[0] = stair[0];
            stairlog[1] = stair[0] + stair[1];
            stairlog[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
            for (int i = 3; i < N; i++) {
                stairlog[i] = Math.max(stairlog[i - 3] + stair[i] + stair[i - 1], stairlog[i - 2] + stair[i]);
            }
        }
    }
}
