package algorithm.DP;
import java.util.Scanner;

/**
 * 주어진 숫자 N 을 가장 빠르게 1로 만들어라
 * 3가지 방법  : 3으로 나누기 , 2 로 나누기 , 1 빼기
 * 3 or 2 로 나누어질 경우 -1 을 실행해라
 * 가장 짧은 시행 결과를 구하여라 
 * 
 * 예시1) N = 10 일때
 * 10 ->9 -> 3 -> 1 : 총 3회 출력
 * 
 * 예시) N = 40일떄
 * 40 -> 20 -> 10 -> 9 -> 3 -> 1  : 총 5회 출력
 * 
 */

public class DFS_findNone {
    public DFS_findNone(){
        Scanner sc = new Scanner(System.in);
        System.out.print("number Input : ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(getList(n));
    }

    private static int getList(int N) {
        int[] list = new int[N+1];
        for(int i = 2; i<N+1; i++){
            list[i] = list[i-1];
            if(i % 3 == 0){
                list[i] = Math.min(list[i], list[i/3]);
            }
            if(i%2 == 0){
                list[i] = Math.min(list[i], list[i/2]);
           }
           list[i]++;
        }
        return list[N];
    }
}