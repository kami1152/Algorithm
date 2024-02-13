package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class back_18870 {

    static HashMap<Integer, Integer> ranking = new HashMap<Integer, Integer>();
    List
    static int origin[];
    static int sorted[];
    static int N;

    public back_18870() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(st.nextToken());
            origin[i] = sorted[i] = token;
        }
        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {
            if (!ranking.containsKey(v)) {
                ranking.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranke = ranking.get(key);
            sb.append(ranke).append(' ');
        }

        System.out.println(sb);

    }

}
