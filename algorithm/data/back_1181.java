package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class back_1181 {

    static int N;
    static List<String> list = new ArrayList<>();
    static List<String> list2 = new ArrayList<>();
    static List<String> list3 = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static int len;
    static String[] answers;

    public back_1181() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = new String[n];

        for (int i = 0; i < n; i++)
            data[i] = br.readLine();

        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        System.out.println(data[0]);
        for (int i = 1; i < n; i++) {
            if (!data[i].equals(data[i - 1])) {
                System.out.println(data[i]);
            }
        }
    }

}
