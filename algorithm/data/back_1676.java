package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1676 {
    static int[] pactorial;
    static int count = 0;

    public back_1676() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        pactorial = new int[N];
        pactorial[0] = 1;
        for (int i = 1; i < N; i++) {
            pactorial[i] = pactorial[i - 1] * i;
        }

        for (int i = 0; i < N; i++) {
            if (String.valueOf(pactorial[i]).contains("0")) {
                zerocounter(String.valueOf(pactorial[i]));
            }

        }

        System.out.println(count);

    }

    public static void zerocounter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
    }
}
