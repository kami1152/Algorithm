package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Collection;

public class back_2751 {
    public back_2751() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            list.add(x);
        }
        Collections.sort(list);
       for(int v : list){
            sb.append(v).append("\n");
       }
       System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        back_2751 b = new back_2751();
    }
}

