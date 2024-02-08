package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_16928 {
    static int[] field;
    static int[] fieldinfo;
    static boolean[] visted;
    static Queue<Integer> que = new LinkedList<>();

    static int start = 1;
    static int count = 0;

    public back_16928() throws IOException {
        dfs d = new dfs();
    }

}

class dfs {
    Queue<Integer> que = new LinkedList<>();
    static node[] n = new node[101];
    static int hash = 0;

    public dfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 101; i++) {
            n[i] = new node(i, false);
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            n[x].setnode(y);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            n[u].setnode(v);
        }

        que.offer(n[1].rocation); // 1 set
        n[1].check(); // node info <- true;
        while (!que.isEmpty()) {
            int p = que.poll(); // p = 1 // 2 3 4 5 6 7-99

            // System.out.println(n[p].rocation + " " + n[p].gethash());

            for (int i = 1; i < 7; i++) {

                int next = p + i;
                if (next > 100) {
                    continue;
                }

                if (n[p + i].getvisited()) {
                    continue;
                }
                if (n[p + i].getnextnode() == 0) {
                    que.offer(n[p + i].rocation);
                    n[p + i].hashinfoset(n[p].gethash());
                    n[p + i].check();
                }
                if (n[p + i].getnextnode() != 0) {

                    que.offer(n[p + i].getnextnode());
                    n[p + i].hashinfoset(n[p].gethash());
                    n[n[p + i].getnextnode()].hashinfoset(n[p].gethash());
                    n[p + i].check();
                    n[n[p + i].getnextnode()].check();

                }
                if (n[p + i].rocation == 100) {
                    break;
                }
                // System.out.println(n[p + i].rocation + "-" + n[p + i].gethash());
            }
        }

        System.out.println(n[100].gethash());
    }

    private static class node {
        public int rocation;
        private boolean visted;
        private int hashinfo = 0;
        private int nextnode = 0;

        private node(int rocation, boolean visted) {
            this.rocation = rocation;
            this.visted = visted;
        }

        public void hashinfoset(int hash) {
            this.hashinfo = ++hash;
        }

        public int gethash() {
            return hashinfo;
        }

        public void setnode(int nextnode) {
            this.nextnode = nextnode;
        }

        public int getnextnode() {
            return nextnode;
        }

        public void check() {
            this.visted = true;
        }

        public boolean getvisited() {
            return visted;
        }
    }
}
