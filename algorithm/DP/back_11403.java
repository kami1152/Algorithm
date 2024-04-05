package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_11403 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int Node[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Node[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 순회노드


        for (int i = 0; i < N; i++) {
            // 출발 노드
            for (int j = 0; j < N; j++) {
                // 도착 노드
                for (int k = 0; k < N; k++) {
                    // 출발 -> 순회 -> 도착 경로 확인
                    // 경로 존재 시 1
                    if (Node[j][i] == 1 && Node[i][k] == 1) {
                        Node[j][k] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(Node[i][j]);
                if (j != N - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
