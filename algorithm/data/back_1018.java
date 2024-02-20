package algorithm.data;

import java.util.*;
import java.io.*;

public class back_1018 {

    static boolean[][] board;
    static int min = 64;

    public back_1018() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (String.valueOf(str.charAt(j)).equals("B")) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
        // 8 10
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                finder(i, j);
            }
        }
        System.out.println(min);
    }

    public static void finder(int startY, int startX) {
        boolean starter = board[startX][startY];
        int count = 0;
        for (int i = startY; i < startY + 8; i++) {
            for (int j = startX; j < startX + 8; j++) {
                if (board[i][j] != starter) {
                    count++;
                }

                starter = (!starter);

            }
            starter = (!starter);

        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }

}
