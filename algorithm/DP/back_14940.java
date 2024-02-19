package algorithm.DP;

import java.io.*;
import java.util.*;

public class back_14940 {

    static int N, M;
    static Node[][] node;
    static int log = 0;
    static Queue<Node> que = new LinkedList<>();

    public back_14940() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x
        node = new Node[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // j 가로 , i 세로
                int item = Integer.parseInt(st.nextToken());
                node[i][j] = new Node(j, i, item);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (node[i][j].id == 2) {
                    bfs(i, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!node[i][j].visited && node[i][j].id == 1 && node[i][j].log == 0) {
                    node[i][j].log = -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(node[i][j].log + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int y, int x) {
        node[y][x].inputlog(log);
        node[y][x].visited = true;
        que.offer(node[y][x]);
        while (!que.isEmpty()) {
            Node nxnode = que.poll();
            int nwlog = nxnode.log;
            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int nx = nxnode.x + dx[i];
                int ny = nxnode.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
                    continue;
                }
                // System.out.println(nx + " " + ny);
                if (node[ny][nx].id == 1 && !node[ny][nx].visited) {
                    node[ny][nx].visited = true;
                    node[ny][nx].log = nwlog + 1;
                    que.offer(node[ny][nx]);
                } else {
                    node[ny][nx].visited = true;
                }
            }
        }

    }

    public static class Node {
        public int x, y, id;
        public int log;
        public boolean visited = false;

        public Node(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }

        public void inputlog(int log) {
            this.log = log;
        }
    }

}
