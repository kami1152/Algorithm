package algorithm;

import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N ; i ++){
            int cnt = i + 1;
            while(cnt != 0){
                System.out.print("*");
                cnt--;
            }
            
        }
    }
}