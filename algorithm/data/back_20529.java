package algorithm.data;

import java.util.*;
import java.io.*;

public class back_20529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Map<Integer, String> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String p = st.nextToken();
                map.put(j, p);
            }
            System.out.println(func(map, N));
        }
    }

    static public int func(Map gmap, int num) {
        if(num > 32 ){
            return 0;
        }
        // System.out.println(gmap.get(0));
        Map<Integer, String> map = gmap;
        // System.out.println(map.get(0));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            map.get(i);
            for (int j = 1; j < num; j++) {
                for (int k = 1; k < num; k++) {
                    String t1 = map.get(i);
                    String t2 = map.get(i + j);
                    String t3 = map.get(i + j + k);
                    // System.out.println(min);
                    if (t1 != null && t2 != null && t3 != null) {
                        min = Math.min(min, count(t1, t2, t3));
                    }
                }
            }
        }
        return min;
    }

    static public int count(String t1, String t2, String t3) {
        int count = 0;
        for (int i = 0; i < t1.length(); i++) {
            if (t1.charAt(i) != t2.charAt(i)) {
                count++;
            }
            if (t1.charAt(i) != t3.charAt(i)) {
                count++;
            }
            if (t2.charAt(i) != t3.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
