package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_11399 {
    static int N;
    static int[] P;
    static int sum = 0;
    static int delay = 0;

    public back_11399() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        for (int i = 0; i < N; i++) {
            sum += P[i] + delay;// 1 2 3 3 4
            delay += P[i]; // 1 3 6 9 10
        }
        System.out.println(sum);

    }
}
