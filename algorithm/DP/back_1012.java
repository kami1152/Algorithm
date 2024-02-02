package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1012 {

    static int M, N, K;

    static int[][] node;
    static boolean[][] nodelog;

    public back_1012() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casetest = Integer.parseInt(br.readLine());
        int cnt;
        for (int i = 0; i < casetest; i++) {
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            node = new int[N][M];
            nodelog = new boolean[N][M];

            K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                node[p2][p1] = 1; // nodemap make
            }

            for (int y = 0; y < N; y++) { // M - 4 N - 1
                for (int x = 0; x < M; x++) {
                    if (node[y][x] == 1 && nodelog[y][x] == false) {
                        // start finder!
                        nodefinder(x, y);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }

    static void nodefinder(int x, int y) { // 1 1 1 1 M = 4 N = 1

        nodelog[y][x] = true;
        if (x > 0) {
            if (node[y][x - 1] == 1 && !nodelog[y][x - 1]) {
                nodefinder(x - 1, y);
            }
        }
        if (x < M-1) {
            if (node[y][x + 1] == 1 && !nodelog[y][x + 1]) {
                nodefinder(x + 1, y);
            }
        }
        if (y>0) {
            if (node[y - 1][x] == 1 && !nodelog[y - 1][x]) {
                nodefinder(x, y - 1);
            }
        }
        if (y < N-1) {
            if (node[y + 1][x] == 1 && !nodelog[y + 1][x]) {
                nodefinder(x, y + 1);
            }
        }
    }

    static void nextnode(int[][] field) {

    }

    static void findparent() {

    }
}
