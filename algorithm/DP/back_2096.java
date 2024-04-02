package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_2096 {

    static int N;
    static Stair[][] stair;
    static Stair[][] stair2;

    public back_2096() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        stair = new Stair[N][3];
        stair2 = new Stair[N][3];
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int x = Integer.parseInt(st.nextToken());
                stair[i][j] = new Stair(j, x);
                stair2[i][j] = new Stair(j, x);

            }
        }

        for (int k = 0; k < N - 1; k++) {
            for (int i = 0; i < 3; i++) {
                int now = stair[k][i].size[0];
                int now2 = stair2[k][i].size[0];
                finder2(i, k, now);
                finder3(i, k, now2);
            }
            for (int i = 0; i < 3; i++) {

                stair[k+1][i].size[0] = stair[k+1][i].maxsize;
                stair2[k+1][i].size[0] = stair2[k+1][i].minsize;
                //System.out.println(stair[k+1][i].size[0]);
                System.out.print(stair2[k+1][i].size[0]+" ");
            }
           System.out.println();
            
        }


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, stair[N-1][i].size[0]);

            min = Math.min(min, stair2[N-1][i].size[0]);
        }
        System.out.println(max + " " + min);

    }

    //y 는 높이
    static public void finder2(int x, int y,  int now) {
        int[] dx = { -1, 0, 1 };
        for (int i = 0; i < 3; i++) {
            int nx = dx[i]+x; // x 는 0 1 2 순회 
            int ny = y + 1;
            if (nx >= 0 && nx < 3 && ny < N) {
                int max = now+stair[ny][nx].size[0]; // 현재 층 수 + 다음 층 수 탐색

                stair[ny][nx].maxsize = Math.max(max , stair[ny][nx].maxsize);       
            }   
        }
    }

    static public void finder3(int x, int y, int now) {
        int[] dx = { -1, 0, 1 };
        for (int i = 0; i < 3; i++) {
            int nx = dx[i]+x; // x 는 0 1 2 순회 
            int ny = y + 1;
            if (nx >= 0 && nx < 3 && ny < N) {
                int min = now+stair2[ny][nx].size[0]; 
               // System.out.println("y"+ min);     
                stair2[ny][nx].minsize = Math.min(min , stair2[ny][nx].minsize);  
                //System.out.println("x"+stair2[ny][nx].minsize);     
            }   
        }
    }


    public class Stair {
        public int index;
        public int[] size = new int[2];
        public int maxsize = Integer.MIN_VALUE;
        public int minsize = Integer.MAX_VALUE;

        public boolean visited = false;

        public Stair(int index, int size) {
            this.index = index;
            this.size[0] = size;
            this.size[1] = size;


        }
    }

    public static void main(String[] args) throws IOException {
        back_2096 b = new back_2096();
    }
}
