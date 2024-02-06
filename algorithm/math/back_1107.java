package algorithm.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1107 {

    static int now = 100;
    static int count = 0;
    static boolean[] errorbtn;

    public back_1107() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        errorbtn = new boolean[10];
        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        if (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                errorbtn[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int res = finder(target);
        System.out.println(res);
    }
    //

    static int finder(int target) {
        int res = Math.abs(target - now);
        if (target == 100) {
            return 0;
        }
        for (int i = 0; i <= 1000000; i++) {
            if (check(i)) {
                int lens = Integer.toString(i).length();
                int find = Math.abs(target - i) + lens;
                res = Math.min(res, find);
                if (res == 1) {
                    return res;
                }
            }
        }
        return res;
    }

    static boolean check(int i) {
        String str = Integer.toString(i); // "1234" 문자열을 1 2 3 4 각각 하나씪 가져와서 출력해보고 사용하고 싶어
        for (String itme : str.split("")) {
            if (errorbtn[Integer.parseInt(itme)]) {
                return false;
            }
        }
        return true;
    }

}
