package algorithm.data;

import java.util.*;
import java.io.*;

public class back_1874 {

    static List<Integer> stack2 = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public back_1874() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append('-').append('\n');

        }
        System.out.println(sb);

    }

}
