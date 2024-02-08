package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class back_1260 {
    static node[] n;

    public back_1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        n = new node[N + 1];
        for (int i = 0; i < N + 1; i++) {
            n[i] = new node(i, false, N + 1);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            n[x].setlinknode(y);
            n[y].setlinknode(x);
        }
        for (int i = 0; i < N + 1; i++) {
            n[i].sortlink();
        }
        // System.out.println("-" + n[4].local + " " + n[4].linknodes[1]);

        dfs(V);
        System.out.println();
        for (int i = 0; i < N + 1; i++) {
            n[i].reversevisited();
        }
        bfs(V);

    }

    static void bfs(int V) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(n[V].local);
        n[V].checkvisited();
        while (!que.isEmpty()) {
            int x = que.poll(); // 1 -2,3
            System.out.print(x + " ");
            int start = 0;
            if (n[x].cnt != 0) { // node 가 연결된 간선 수 확인
                int count = n[x].cnt;
                while (count != 0) { // 간선 수가 없어 질때 까지 큐에 삽입
                    // System.out.println("*" + n[n[x].linknodes[start]].local);
                    if (n[n[x].linknodes[start]].visited) {
                        count--;
                        start++;
                        continue;
                    }
                    que.offer(n[x].linknodes[start]); // 추가된 다음 노트 큐 삽입
                    n[n[x].linknodes[start]].checkvisited(); // 삽입된 노드는 중복 방지를 위해 체크
                    count--;// 간선수 카운팅
                    start++;
                }
            }

        }
    }

    static void dfs(int V) {
        n[V].checkvisited();
        System.out.print(n[V].local + " ");
        if (n[V].cnt != 0) {
            for (int i = 0; i < n[V].cnt; i++) {
                if (!n[n[V].linknodes[i]].visited) {
                    dfs(n[V].linknodes[i]);
                }

            }
        }

    }

    private static class node {
        public int local;
        public boolean visited;
        public int[] linknodes;
        public int cnt = 0;
        private int N;

        public node(int local, boolean visited, int N) {
            this.local = local;
            this.N = N;
            this.visited = visited;
            this.linknodes = new int[N];
            for (int i = 0; i < N; i++) {
                linknodes[i] = N + 1000;
            }
        }

        public void sortlink() {
            Arrays.sort(linknodes);
        }

        public void setlinknode(int linknode) {
            this.linknodes[cnt] = linknode;
            cnt++;
        }

        public void checkvisited() {
            this.visited = true;
        }

        public void reversevisited() {
            this.visited = false;
        }

    }
}
