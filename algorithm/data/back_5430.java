package algorithm.data;

import java.io.*;
import java.util.*;

public class back_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new ArrayDeque<Integer>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],"); // [1,2,3,4]
            for (int j = 0; j < n; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            System.out.println(ac2(deque, p));

        }
    }

    public static String ac2(Deque<Integer> deque, String p) {
        boolean rstate = false;
        for (char a : p.toCharArray()) {
            if (a == 'R') {
                if (rstate) {
                    rstate = false;
                } else {
                    rstate = true;
                }
            }
            if (a == 'D') {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (rstate) {
                    // rstate true = "뒤집어져 있습니다" <- 1 2 3 4 4 3 2 1 <- 이상태이므로 , 1 2 3 4 addfirst
                    deque.pollLast();
                } else {
                    deque.pollFirst();

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!deque.isEmpty()) {
            if (rstate) {
                int a = deque.pollLast();
                sb.append(String.valueOf(a));
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }else{
                int a = deque.pollFirst();
                sb.append(String.valueOf(a));
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static String ac(Deque<Integer> deque, String p) {
        String msg = "";
        // System.out.println(p);
        for (char a : p.toCharArray()) {
            // System.out.println(a);
            if (a == 'R') {
                deque = reversedeque(deque);
                // System.out.println(deque);
            }
            if (a == 'D') {
                if (deque.isEmpty()) {
                    msg = "error";
                    return msg;
                } else {
                    deque.pollFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            int a = deque.pollFirst();
            sb.append(String.valueOf(a));
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        msg = sb.toString();
        return msg;
    }

    public static Deque<Integer> reversedeque(Deque<Integer> deque) {
        Deque<Integer> ndeque = new ArrayDeque<Integer>();

        while (!deque.isEmpty()) {
            ndeque.add(deque.pollLast());
        }
        return ndeque;
    }

}
