package algorithm.data;

import java.util.*;

public class back_2562 {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(sc.nextLine());
            if(max < n){
                max = n;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}