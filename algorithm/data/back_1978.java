package algorithm.data;

import java.util.*;

import algorithm.data.back_1966.Paper;

import java.io.*;

public class back_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for(int i = 0 ;  i < N ; i ++ ){
            int num = Integer.parseInt(st.nextToken());
            if(func(num)){
                res++;
            }
        }
        System.out.println(res);
    }
    public static boolean func(int num){
        int n = 0;
        if(num == 1){
            return false;
        }
        for(int i = 1 ; i <= num ; i++){
            if(num % i == 0){
                n++;
            }
            if(n>2){
                return false;
            }
        }
        return true;
    }
}
