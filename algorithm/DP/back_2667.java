package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class back_2667 {
    static int size;
    static Node[][] node;
    static int count = 0;
    static List<Integer> list = new ArrayList<>();
    static int box[][];
    static int log = 1;

    public back_2667() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        node = new Node[size][size];
        box = new int[size][size];
        for (int j = 0; j < size; j++) {
            String str = br.readLine();

            for (int i = 0; i < size; i++) {
                node[j][i] = new Node(i, j, str.charAt(i) - '0');
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (node[i][j].id != 0 && !node[i][j].visited) {
                    // System.out.println(node[j][i].id + " x- " + i + " y- " + j);
                    dps(j, i, log);
                    list.add(count);
                    count = 0;
                    log++;
                }
            }
        }

        Collections.sort(list);
        if (list.size() != 0) {
            System.out.println(list.size());
        }

        for (int item : list) {
            System.out.println(item);
        }
    }

    public void dps(int x, int y, int log) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        node[y][x].id = log;
        node[y][x].visited = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                if (node[ny][nx].id != 0 && !node[ny][nx].visited) {
                    dps(nx, ny, log);
                }
            }
        }
        count++;

    }

    public static class Node {
        public int x;
        public int y;
        public int id;
        public boolean visited = false;

        public Node(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }

        public void visited() {
            this.visited = true;
        }
    }
}
