package algorithm.data;

import java.util.*;
import java.io.*;

public class programers_Stringzip {
    public static void main(String[] args) {
        String str = "abcabcd";
        Solution s = new Solution();
        str.substring(0, 2);
        System.out.println(s.solution(str));
    }

    public static class Solution {

        public int solution(String s) {

            int answer = Integer.MAX_VALUE;
            int len = s.length();
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= len / 2; i++) {
                StringBuffer sb = new StringBuffer();
                String compare = "";
                int cnt = 1;
                for(int j = 0; j <= len-i; j += i){
                    String temp = s.substring(j, j+i);
                    //System.out.println(temp);
                    if(compare.equals(temp)){
                        cnt ++;
                    }else{
                        if(cnt > 1){
                            sb.append(cnt+compare);
                        }else{
                            sb.append(compare);
                        }
                        //System.out.println(sb.toString());
                        cnt = 1;
                    }
                    compare = temp;
                }
                if(cnt > 1){
                    sb.append(cnt+compare);
                }else{
                    sb.append(compare);
                }
                if(len%i != 0){
                    String x = s.substring(len-(len%i),len);
                    sb.append(x);
                }
                //System.out.println(sb.toString());
                String com = sb.toString();
                answer = Math.min(com.length(),answer);
            }

            return answer;
        }

     
    }
}
