package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class back_1620 {

    static int N;
    static int M;

    static poketmon[] _poketmon;
    static Map<String, Integer> _monster = new HashMap<String, Integer>();

    public back_1620() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        _poketmon = new poketmon[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String s = br.readLine();
            _poketmon[i] = new poketmon(i, s);
            _monster.put(s, i);
        }
        for (int j = 0; j < M; j++) {
            String x = br.readLine();
            if (x.chars().allMatch(Character::isDigit)) {
                int id = Integer.parseInt(x);
                System.out.println(_poketmon[id].name);
            } else {
                System.out.println(_monster.get(x));
            }
        }

    }

    public static class poketmon {
        public String name;
        public int id;

        public poketmon(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }

}
