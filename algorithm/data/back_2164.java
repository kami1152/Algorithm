package algorithm.data;
import java.util.*;

public class back_2164 {

    Deque<Integer> deque = new ArrayDeque<Integer>();

    public back_2164() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i < N+1; i++) {
            deque.addLast(i);
        }
        while(deque.size() != 1){
            deque.removeFirst();
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.poll());
    }
    public static void main(String[] args) {
        back_2164 a = new back_2164();
    }

}
