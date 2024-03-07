package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class back_11651 {
    public back_11651() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        sc.nextLine();
        int[][] p = new int[N][2];
        for (int i = 0; i < N; i++) {
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
            sc.nextLine();
        }

        Arrays.sort(p, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for(int[] items : p){
           sb.append(items[0]+" "+items[1]).append('\n');
        } 
        System.out.println(sb);

    }
    public static void main(String[] args) {
        back_11651 b = new back_11651();

    }
}
