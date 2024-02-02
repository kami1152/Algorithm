package algorithm.DP;

import java.util.Scanner;

public class fibonaccDP {
    static int[] c = new int[2];

    public fibonaccDP() {
        Scanner sc = new Scanner(System.in);
        int _case = sc.nextInt();
        int[] _fica = new int[_case];
        for (int i = 0; i < _case; i++) {
            int N = sc.nextInt();
            _fica[i] = N;
        }
        for (int num : _fica) {
            newfibonacci(num);
        }
    }

    // 0 1 1 2 3 5 8. . .
    // 10 01 11 12 23 35 5 8
    static void newfibonacci(int n) { // n = 0 , n = 3
        int[][] reroOne = new int[n + 3][2];
        reroOne[0][0] = 1;
        reroOne[0][1] = 0;
        reroOne[1][0] = 0;
        reroOne[1][1] = 1;
        int i = 2;
        while (i != n+1) {
            reroOne[i][0] = reroOne[i - 1][0] + reroOne[i - 2][0];
            reroOne[i][1] = reroOne[i - 1][1] + reroOne[i - 2][1];
            i++;
            if (n == 0 || n == 1) {
                break;
            }
        }
        System.out.println("------------------");
        // fibo generate
        System.out.println(reroOne[n][0] + " " + reroOne[n][1]);

    }

}