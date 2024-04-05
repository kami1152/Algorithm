package algorithm.data;

import java.util.*;

public class back_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < 10; i++) {

            int n = Integer.parseInt(sc.nextLine())%42;
            if(!set.contains(n)){
                set.add(n);
                cnt++;
            }
                
        }
        System.out.println(cnt);
    }
}
