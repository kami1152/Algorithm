package algorithm.data;

import java.util.*;
import java.io.*;

public class back_1436 {

    public back_1436() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int parsing = 0;
        while (count != N) {
            parsing++;
            // System.out.println(parsing);
            if (String.valueOf(parsing).contains("666")) {
                count++;
            }
        }
        System.out.println(parsing);

    }

}
