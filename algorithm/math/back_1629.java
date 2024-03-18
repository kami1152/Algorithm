package algorithm.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_1629 {

    public back_1629() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        System.out.println(pow(A, B, C));
    
    }
    public long pow(int a , int b, int c){
        if(b == 0 ){
            return 1;
        }
        long n = pow(a, b/2, c);
        if(b % 2 == 0){
            return n * n % c;
        }else{
            return (n*n%c) * a % c;
        }

    }


    public static void main(String[] args) throws IOException {
        back_1629 b = new back_1629();
    }
}
