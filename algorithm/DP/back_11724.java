package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_11724 {

    static boolean[] visted;
    static int[][] nodeline;
    static int N;
    static int M;

    public back_11724() throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visted = new boolean[N + 1];
        nodeline = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            nodeline[u][v] = nodeline[v][u] = 1;
        }

        for (int j = 1; j <= N; j++) {
            if (!visted[j]) {
                dfs(j);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int i) {
        visted[i] = true;
        for (int j = 1; j <= N; j++) {
            if (nodeline[i][j] == 1 && !visted[j]) {
                dfs(j);
            }
        }
    }
}
