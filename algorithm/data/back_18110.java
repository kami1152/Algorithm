package algorithm.data;
import java.util.*;
import java.io.*;
public class back_18110 {
    int _min = Integer.MAX_VALUE;
    int _max = Integer.MIN_VALUE;
    public back_18110() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int ignore = Math.round((float)N*15/100);
        //System.out.println(ignore);
        int[] ns1 = new int[N];
        for(int i = 0; i < N ; i++){
            ns1[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        int cnt = 0;
        Arrays.sort(ns1);// 1 2 3
        for(int i = 0+ignore; i < N-ignore;i++){
            sum += ns1[i];
            cnt++;
        }
        //System.out.println(sum);

        int result= 0;
        if(cnt != 0){
            result = Math.round((float)sum/cnt);
        }
        System.out.println(result);
    }
}
