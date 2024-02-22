package algorithm.data;

import java.io.*;
import java.util.*;

public class back_11650 {

    List<List<Integer>> list = new ArrayList<>();
    static Node[] node;

    public back_11650() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[i] = new Node(x, y);
        }

        Arrays.sort(node, (a, b) -> {
            if (a.x == b.x) {
                return Integer.compare(a.y, b.y);
            } else {
                return Integer.compare(a.x, b.x);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(node[i].x + " " + node[i].y);
        }

    }

    static public class Node {

        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
