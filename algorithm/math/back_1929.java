package algorithm.math;

import java.util.*;

public class back_1929 {
    static int[] list;
    static List<Integer> lists = new ArrayList<>();

    public back_1929() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        finder2(x, y);
        for (Integer o : lists) {
            System.out.println(o);
        }
    }

    static void finder2(int start, int end) {
        list = new int[end + 1];

        for (int i = 2; i <= end; i++) {
            list[i] = i;
        }

        for (int i = 2; i <= end; i++) {
            if (list[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= end; j = j + i) {
                list[j] = 0;
            }
        }
        for (int i = start; i <= end; i++) {
            if (list[i] != 0)
                lists.add(i);
        }
    }

    static void finder(int start, int num) {
        for (int i = start; i <= num; i++) {
            int cnt = 0;
            if (i == 1) {
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
                if (cnt == 3) {
                    break;
                }
            }
            // System.out.println(cnt);
            if (cnt == 3) {
                continue;
            }
            if (cnt == 2) {
                lists.add(i);
            }

        }

    }
}
