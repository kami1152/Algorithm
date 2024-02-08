package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Character;

public class back_1541 {

    static String[] numbers = new String[100];
    static String[] operator = new String[100];
    static boolean flag = false;
    static int x = 0;
    static int y = 0;

    public back_1541() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1-1-1+1+1-1+1+1
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        // 1 1 1+1+1 1+1+1
        int sum = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
