package algorithm.DP;

import java.util.Scanner;
import java.util.StringTokenizer;

public class back_2606 {

    static int N;
    static int M;
    static node[] n;

    static int virus = 0;

    public back_2606() {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringTokenizer st;
        n = new node[N];
        for (int i = 0; i < N; i++) {
            n[i] = new node(i, false, N);
        }
        int M = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(sc.nextLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            n[x].setlinknode(y);
            n[y].setlinknode(x);
        }

        int x = 0;
        dfs(x);
        System.out.println(virus);
        sc.close();

    }

    static void dfs(int x) {
        n[x].checkvisited();
        if (n[x].line != 0) {
            for (int i = 0; i < n[x].line; i++) {
                if (!n[n[x].linknodes[i]].visited) {
                    virus++;
                    dfs(n[x].linknodes[i]);
                }
            }

        }

    }

    public static class node {
        private int local;
        public boolean visited;
        public int linknodes[];
        public int line = 0;

        public node(int local, boolean visited, int N) {
            this.local = local;
            this.visited = visited;
            linknodes = new int[N];
        }

        public void setlinknode(int x) {
            linknodes[line] = x;
            line++;
        }

        public void checkvisited() {
            this.visited = true;
        }

    }
}
