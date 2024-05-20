package algorithm.data;

import java.util.*;

public class pro_240520 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("banana"));
    }

    static class Solution {

        public int[] solution(String s) {
            int[] str = new int[s.length()];
            Map<String, Integer> map = new HashMap<>();
            int locate = 0;
            int cnt = 0;
            for (char item : s.toCharArray()) {
                if (map.containsKey(String.valueOf(item))) {
                    locate = map.get(String.valueOf(item));
                    str[cnt] = cnt - locate;
                    map.put(String.valueOf(item), cnt);
                } else {
                    str[cnt] = -1;
                    map.put(String.valueOf(item), cnt);
                   
                }  
                cnt++;  
            }
            return str;
        }
    }
}
