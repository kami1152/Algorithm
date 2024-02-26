package algorithm.data;

import java.util.*;
import java.io.*;

public class back_10845 {

    static Queue<Integer> que = new LinkedList<>();
    static Deque<Object> deque = new ArrayDeque<>();

    public back_10845() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")) {
                int t = Integer.parseInt(st.nextToken());
                deque.addFirst(t);
            }
            if (str.equals("pop")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(deque.peekLast());
                deque.removeLast();
            }
            if (str.equals("size")) {
                System.out.println(deque.size());
            }
            if (str.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            if (str.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(deque.peekLast());

            }
            if (str.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }

                System.out.println(deque.peekFirst());
            }

        }

    }
}
