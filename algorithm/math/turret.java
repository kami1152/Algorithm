package algorithm.math;


import java.util.Scanner;


public class turret {

    public turret(){
        Scanner sc = new Scanner(System.in);
        int _case = Integer.parseInt(sc.nextLine());
        int[] _casearr = new int[_case];
        for (int i = 0; i<_case; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            _casearr[i] = check(x1, y1, r1, x2, y2, r2);  
        }
        for (int item : _casearr){
            System.out.println(item);
        }


    }

    static int check(int x1, int y1, int r1, int x2, int y2, int r2){
        double x = (x2-x1)*(x2-x1);
        double y = (y2-y1)*(y2-y1);
        double z = Math.sqrt(x+y);

        if(x1-x2 == 0 && y1-y2== 0 && r1==r2){
            return -1;
        }
        double longr = Math.max(r1, r2);
        double shortr = Math.min(r1, r2);

        if ((r1+r2)<z || longr>z+shortr){
            return 0;
        } else if((r1+r2) == z || longr == z + shortr){
            return 1;
        } else {
            return 2;
        } 
    }
     
}