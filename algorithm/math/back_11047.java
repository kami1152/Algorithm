package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11047 {

    static int N;
    static int K;
    static int resK;
    static int count;
    static int[] log;
    static Coin[] coin;

    public back_11047() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        resK = K;
        coin = new Coin[N];
        count = 0;
        log = new int[100000000];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            coin[i] = new Coin(i, value);
        }

        finder2(N - 1);
        System.out.println(count);
    }

    public static void finder(int hash) {
        int i = hash;

        if (resK < coin[0].value) { // 만일 계산하다가 남은 값이 최소동전보다 많다면 ex resk = 5 , coin[0] = 10
            count++;
            return;
        }
        int _sel = resK - coin[i].value; // 남은금액 - 코인밸류

        if (_sel > 0) {// 지불
            resK -= coin[i].value;
            count++;
            finder(i);
        } else if (_sel == 0) {
            count++;
            return;
        } else {
            finder(i - 1);
        }
    }

    public static void finder2(int hash) {
        int i = N - 1;
        while (true) {
            if (i < 0) {
                count++;
                break;
            }
            int res = resK - coin[i].value;
            if (res > 0) {
                resK -= coin[i].value;
                count++;
                continue;
            }
            if (res == 0) {
                count++;
                break;
            }
            if (res < 0) {
                --i;
            }
        }
    }

    public static class Coin {

        public int local;
        public int value;

        public Coin(int local, int value) {
            this.local = local;
            this.value = value;
        }

    }

}
