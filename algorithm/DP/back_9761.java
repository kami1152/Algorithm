package algorithm.DP;

import java.util.*;

public class back_9761 {
    public back_9761() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            System.out.println(func(N));
        }
    }

    public long func(int N) {
        long[] arr = new long[N];
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 1;
        }
        if (N == 3) {
            return 1;
        }
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < N; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        return arr[N - 1];
    }

    public static void main(String[] args) {
        back_9761 b = new back_9761();
    }
}
