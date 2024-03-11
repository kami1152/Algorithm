package algorithm.DP;

import java.util.*;

public class back_2178 {
    static int N;
    static int M;
    static Node[][] node;
    public back_2178() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        node = new Node[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                node[i][j] = new Node(i, j);
                //System.out.println(s.charAt(j));
                if(s.charAt(j) == '1'){
                    node[i][j].index = 1;
                }
            }
        }
        Queue<Node> que = new LinkedList<>();
        node[0][0].visited = true;
        que.offer(node[0][0]);
        while (!que.isEmpty()) {
            Node n = que.poll();
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
            for(int i =0; i<4 ; i++){
                int nx = dx[i] + n.x;
                int ny = dy[i] + n.y;
                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(!node[ny][nx].visited && node[ny][nx].index!=0){
                        node[ny][nx].index = n.index+1;
                        node[ny][nx].visited = true;
                        que.offer(node[ny][nx]);
                    }
                }
                if(ny == N-1 && nx == M-1){
                    break;
                }
            }  
        }
        System.out.println(node[N-1][M-1].index);
    }
    public static class Node {
        public int x;
        public int y;
        public int index=0;
        public boolean visited = false;
        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
        public void setindex(int index){
            this.index += index;
        }

    }
}
