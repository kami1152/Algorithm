package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class back_1697 {
    static boolean[] visited = new boolean[200001];
    static int[] map = new int[200001];
    static int[] maplog = new int[200001];
    static int step = 0;

    static Queue<Integer> que = new LinkedList<>();

    public back_1697() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        que.offer(N);

        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == K) {
                System.err.println(map[x]);
                break;
            }
            visited[x] = true;
            // System.out.println(x + ": " + map[x]);
            if (x + 1 == K || x * 2 == K || x - 1 == K) {
                System.out.println(map[x] + 1);
                break;
            }

            if (x + 1 != K && x + 1 < 200001) {
                if (!visited[x + 1]) {
                    que.offer(x + 1);
                    visited[x + 1] = true;
                    map[x + 1] = map[x] + 1;
                }
            }
            if (x > 0 && (x - 1 != K)) {
                if (!visited[x - 1]) {
                    que.offer(x - 1);
                    visited[x - 1] = true;
                    map[x - 1] = map[x] + 1;
                }
            }
            if (x * 2 != K && x * 2 < 200001) {
                if (!visited[x * 2]) {
                    que.offer(x * 2);
                    visited[x * 2] = true;
                    map[x * 2] = map[x] + 1;
                }
            }

        }

    }
}
