package algorithm.data;

import java.util.Scanner;
 
public class back_7568 {
	public back_7568 (){
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		int[][] arr = new int[N][2];
 
		for(int i = 0; i < N; i++) {
			arr[i][0] = in.nextInt();	
			arr[i][1] = in.nextInt();	
		}
		
		
		for(int i = 0; i < N; i++) {
			int rank = 1;
			
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
 
			System.out.print(rank + " ");
		}
 
	}
}