package algorithm.math;

import java.util.Scanner;

public class back_9095 {
    static int[] N = new int[20];
    static int[] X;

    public back_9095() {
        Scanner aa = new Scanner(System.in);
        int a = Integer.parseInt(aa.nextLine());
        X = new int[a];
        for (int i = 0; i < a; i++) {
            X[i] = Integer.parseInt(aa.nextLine());
        } // 4 7 10
        for (int i = 0; i < a; i++) {
            System.out.println(dp(X[i]));
        }
    }

    static private int dp(int n) {

        if (n == 0) {
            return 0;
        }
        N[0] = 1; // 1
        N[1] = 2; // 11 2
        N[2] = 4; // 111 12 21 3

        for (int i = 3; i < n; i++) {
            N[i] = N[i - 1] + N[i - 2] + N[i - 3];
        }
        return N[n - 1];
    }
}
