package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1074 {

    static int x = 0;
    static int y = 0;
    static int cnt = 0;

    public back_1074() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = (int)Math.pow(2, N);


        int res = finder(x, r, c);
        System.out.println(res);

    }

    public static int finder(int n, int r, int c){
        n = n / 2; //4 -> 2 , 3 1 , 3 3 , 1 1
        // 1 rocation
        if(r<x+n && c < y +n){
            cnt += (n*n*0);
        } else if ( r < x + n && c >= y + n){
            cnt += (n*n*1);
            y += n;
        } else if (c < y +n){
            cnt += (n*n*2);
            x += n;
        } else{
            cnt += (n*n*3);
            x += n;
            y += n;
        }
        if(n==1){return cnt;}
        return finder(n, r, c);

    }
}
