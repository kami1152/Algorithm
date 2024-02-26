package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Collection;

public class back_2751 {
    ArrayList<Integer> list = new ArrayList<>();

    public back_2751() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }

        Collections.sort(list);

        for (int item : list) {
            System.out.println(item);
        }
    }

}
