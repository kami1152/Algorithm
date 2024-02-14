package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.StringTokenizer;

public class back_1764 {

    static int N, M;
    static people[] first;
    static people[] second;
    static int count = 0;

    static List<String> list = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();

    public back_1764() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br
                .readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        first = new people[N];
        second = new people[M];
        for (int i = 0; i < N; i++) {
            String user = br.readLine();
            // first[i] = new people(user, 0);
            map.put(user, 1);
        }
        for (int i = 0; i < M; i++) {
            String user = br.readLine();
            map.put(user, map.getOrDefault(user, 0) + 1);
            if (map.get(user) == 2)
                list.add(user);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String itme : list) {
            System.out.println(itme);
        }

        // finder();

    }

    public void finder() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (first[i].name.equals(second[j].name)) {
                    count++;
                    list.add(first[i].name);
                }

            }
        }
    }

    public static class people {

        public String name;
        public int id; // 0 은 듣 1 은 보

        public people(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public int getid() {
            return id;
        }

    }

}
