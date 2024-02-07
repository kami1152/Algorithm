package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_10026 {

    static int N;
    static String[][] greed;
    static boolean[][] visted;
    static int count = 0;
    static int nwcount = 0;

    public back_10026() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        greed = new String[N][N];
        visted = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            greed[i] = str.split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visted[i][j]) {
                    dps(i, j);
                    count++;
                }
            }
        }

        for (boolean[] items : visted) {
            for (int i = 0; i < N; i++) {
                items[i] = false;
            }
        }

        for (String[] items : greed) {
            for (int i = 0; i < N; i++) {
                if (items[i].equals("G")) {
                    items[i] = "R";
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visted[i][j]) {
                    dps(i, j);
                    nwcount++;
                }
            }
        }

        System.out.println(count + " " + nwcount);

    }

    public static void dps(int i, int j) {
        visted[i][j] = true;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int a = 0; a < 4; a++) {
            int nx = dx[a] + j; // -1 1 0 0
            int ny = dy[a] + i; // 0 0 -1 1
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (greed[i][j].equals(greed[ny][nx]) && !visted[ny][nx]) {
                    dps(ny, nx);
                }
            }
        }
    }
}
