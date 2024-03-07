package algorithm.data;

import java.util.*;

public class back_10816 {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new LinkedHashMap<>();

    public back_10816() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                int v = map.get(temp);
                map.put(temp, ++v);
            }
        }
        sc.nextLine();
        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            if(map.containsKey(x)){
               sb.append(map.get(x)); 
            }else{
                sb.append(0);
            }
            if(i != M-1);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        back_10816 b = new back_10816();
    }
}
