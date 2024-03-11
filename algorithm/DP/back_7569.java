package algorithm.DP;

import java.util.*;

public class back_7569 {
    Tomato[][][] tomato;

    public back_7569() {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();
        tomato = new Tomato[H][N][M];
        Queue<Tomato> que = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tomato[k][i][j] = new Tomato(j, i, k);
                }
            }
        }
        for (int k = 0; k < H; k++) {
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int temp = sc.nextInt();
                    if (temp == 1) {
                        tomato[k][i][j].state = 1;
                        que.offer(tomato[k][i][j]);
                    }
                    if (temp == -1) {
                        tomato[k][i][j].state = -1;
                    }

                }
            }

        }

        while (!que.isEmpty()) {
            Tomato ct = que.poll();
            int[] dx = { -1, 1, 0, 0, 0, 0 };
            int[] dy = { 0, 0, -1, 1, 0, 0 };
            int[] dz = { 0, 0, 0, 0, -1, 1 };
            for (int i = 0; i < dx.length; i++) {
                int nx = ct.x + dx[i];
                int ny = ct.y + dy[i];
                int nz = ct.z + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (tomato[nz][ny][nx].state == 0) {
                        //System.out.println(nz+ " "+ ny +" "+ nx);
                        //System.out.println(ct.z+ " "+ ct.y +" "+ ct.x);
                        tomato[nz][ny][nx].state = ct.state + 1;
                        que.offer(tomato[nz][ny][nx]);
                    }
                }
            }
        }
        int max = -1;
        boolean cc = false;
        for (Tomato[][] ttt : tomato) {
            for (Tomato[] tt : ttt) {
                for (Tomato t : tt) {
                    max = Math.max(max, t.state);
                    if (t.state == 0) {
                        cc = true;
                    }
                }
            }
        }
        if (cc) {
            System.out.println(-1);
        } else {
            System.out.println(max-1);
        }
        sc.close();

    }

    public static void main(String[] args) {
        back_7569 b = new back_7569();
    }

    public class Tomato {

        public int x;
        public int y;
        public int z;
        public int state = 0;

        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

}
