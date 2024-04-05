package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back2_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] node = new Node[N];
        for (int i = 0; i < N; i++) {
            node[i] = new Node();
            node[i].id = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    // start i end j
                    node[i].list.add(node[j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(DFS(node[i], j));
            }
            System.out.println();
        }

    }

    public static int DFS(Node node, int target) {
        int res = 0;
        if (node.id == target) {
            res = 1;
        } else {
            if (!node.list.isEmpty()) {
                for (Node i : node.list) {
                    if (!i.equals(node)) {
                        res = DFS(i, target);
                    }
                }
            }
        }

        return res;
    }

    public static class Node {
        public int id;
        public List<Node> list = new LinkedList<>();

    }
}
