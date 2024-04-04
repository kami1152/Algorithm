package algorithm;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str = sc.readLine();
        String target = sc.readLine();
        int cnt = 0;
        for(char x : str.toCharArray()){
            if(target.equals(String.valueOf(x))){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
