package algorithm.data;

import java.util.*;
import java.lang.*;
import java.io.*;

public class back_11723 {

    static Set<Integer> set = new HashSet<>();
    static int N;

    public back_11723() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int S = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String sw = st.nextToken();
            if (sw.equals("all"))
                S = (1 << 21) - 1;
            else if (sw.equals("empty"))
                S = 0;
            else {
                int item = Integer.parseInt(st.nextToken());
                if (sw.equals("add")) {
                    S |= (1 << item);
                } else if (sw.equals("remove")) {
                    S &= ~(1 << item);
                } else if (sw.equals("check")) {
                    sb.append((S & (1 << item)) != 0 ? 1 : 0).append("\n");
                } else if (sw.equals("toggle")) {
                    S ^= (1 << item);
                }
            }
            System.out.println(sb);

        }

    }

}
