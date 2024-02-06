package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_7576 {
    static int M;
    static int N;
    static int tomato[][];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int count = 0;

    static Queue<int[]> queue = new LinkedList<>();

    public back_7576() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.add(new int[] { i, j }); // 1 5
                }
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[1]; // x
            int y = temp[0]; // y
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) {
                    continue;
                }

                if (tomato[ny][nx] == 0) {
                    tomato[ny][nx] = tomato[y][x] + 1;
                    queue.add(new int[] { ny, nx });
                }
            }
        }
        int max = Integer.MIN_VALUE;

        if (!zerocheck()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomato[i][j] > max) {
                        max = tomato[i][j];
                    }
                }
            }
            return max - 1;
        }
    }

    static boolean zerocheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
