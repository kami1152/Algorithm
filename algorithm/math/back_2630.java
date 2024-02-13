package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2630 {

    static int N;
    static int[][] board;
    static int Bcount = 0;
    static int Wcount = 0;

    public back_2630() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                board[i][j] = x;
            }
        }

        partition(0, 0, N);
        System.out.println(Bcount);
        System.out.println(Wcount);
    }

    public static void partition(int row, int col, int size) {// 8

        if (check(row, col, size)) {
            // System.out.println(Bcount + " - " + Wcount);
            int color = board[row][col];
            if (color == 1) {
                Bcount++;
            } else {
                Wcount++;
            }
            return;
        }

        int newsize = size / 2;
        partition(row, col, newsize);
        partition(row, col + newsize, newsize);
        partition(row + newsize, col, newsize);
        partition(row + newsize, col + newsize, newsize);

    }

    public static boolean check(int row, int col, int size) {
        int start = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }

}
