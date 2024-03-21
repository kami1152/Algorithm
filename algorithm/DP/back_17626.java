package algorithm.DP;


import java.util.*;

public class back_17626 {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    int N  = sc.nextInt();
    int[] arr = new int[N+1];
    arr[0] = 0;
    arr[1] = 1; //1

    for(int i = 2 ; i <= N ; i++){
        int min = Integer.MAX_VALUE;
        for(int j = 1 ; j*j <= i ; j++){
            min = Math.min(min, arr[i-j*j]);
        }
        arr[i] = min + 1;
    }
    System.out.println(arr[N]);
    sc.close();



    }
}
