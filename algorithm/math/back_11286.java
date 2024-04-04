package algorithm.math;

import java.util.*;

public class back_11286 {
    static Map<Integer, Integer> map = new HashMap<>();
    static List<Integer> min = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
        
            new Comparator<Integer>() {
                @Override
                public int compare(Integer a,  Integer b){
                    if(Math.abs(a)==Math.abs(b)){
                        return a-b;
                    }else{
                        return Math.abs(a)>Math.abs(b) ? Math.abs(a)-Math.abs(b) : -1;
                    }
                }
            }
        );

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(sc.nextLine());
            if(x != 0){
                pq.offer(x);
            }else{
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }
        }
        sc.close();
    }

  
}