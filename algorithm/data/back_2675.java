package algorithm.data;

import java.util.*;

public class back_2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            int n = sc.nextInt();
            String str = sc.next();
            sc.nextLine();
            for (char x : str.toCharArray()) {
                for (int j = 0; j < n; j++) {
                    sb.append(String.valueOf(x));
                }
            }
            System.out.println(sb);
        }
    }
}
