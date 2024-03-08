package algorithm.data;

import java.util.*;

public class back_2805 {

    public back_2805() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] trees = new int[N];
        sc.nextLine();
        int tall = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
            tall = Math.max(trees[i], tall);
        }
        int left = 0;
        while (left <= tall) {
           //System.out.println(tall);
           int mid = (left+tall)/2;
            long get = 0;
            for (int tree : trees) {
                if (tree >= mid) {
                    get += (tree - mid);
                }
            }
            //System.out.println(get);
            if (get >= M) {
                left = mid+1;
            } else {
                tall = mid - 1;
            }
        }

        System.out.println(tall);

    }

    public static void main(String[] args) {
        back_2805 b = new back_2805();

    }

}
