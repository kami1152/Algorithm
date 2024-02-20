package algorithm.DP;

import java.util.*;
import java.io.*;

public class back_11726 {
    static int N;
    static int[] list;

    public back_11726() throws IOException {
        // 1 2 3 5 8 13 21 34 55
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[1001];
        list[1] = 1;
        list[2] = 2;
        for (int i = 3; i <= N; i++) {
            list[i] = (list[i - 2] + list[i - 1]) % 10007;

        }
        System.out.println(list[N]);

    }
}
