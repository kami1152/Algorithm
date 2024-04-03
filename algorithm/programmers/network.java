package algorithm.programmers;

import java.util.*;

public class network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        Computers[] com = new Computers[n];
        // n = 컴퓨터 수, computers = 간선정보
        for (int i = 0; i < n; i++) {
            com[i] = new Computers(i);
        }
        int id = 0;
        for (int[] items : computers) {
            // 110 110 001
            int target = 0;
            for (int item : items) {
                // 1 1 0
                if (item == 1) {
                    com[id].set.add(com[target]);
                }
                target += 1;
            }
            id += 1;
        }
        Queue<Computers> que = new LinkedList<>();
        for (Computers c : com) {
            que.offer(c);
            if (!c.visited) {
                answer += 1;
            }
            while (!que.isEmpty()) {
                Computers nc = que.poll();
                if (nc.visited) {
                    continue;
                }
                nc.visited = true;
                while (!nc.set.isEmpty()) {
                    Computers ncc = nc.set.poll();
                    if (!ncc.visited) {
                        que.offer(ncc);
                    }
                }
            }

        }
        return answer;
    }

    public class Computers {
        public Queue<Computers> set = new LinkedList<>();
        int id;
        public boolean visited = false;

        public Computers(int id) {
            this.id = id;
        }
    }
}
