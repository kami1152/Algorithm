package algorithm.data;

import java.util.*;
import java.io.*;

public class back_1966 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Paper> que;
    static Paper paper;

    static int papercounter = 1;

    public back_1966() throws IOException {

        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            printer(N, M);
        }

    }

    public static void printer(int N, int M) throws IOException {
        int count = 0;
        int point = 0;
        que = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int pp = Integer.parseInt(st.nextToken());
            paper = new Paper(pp);
            if (pp > point) {
                point = pp; // 최대값 새팅
            }
            if (i == M) {
                paper.target = true;
            }
            que.offer(paper);
        }
        int _size = que.size();
        int cycle = 0;

        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Paper temppaper = que.poll();
            // System.out.println(point);
            // System.out.print(temppaper.id + " ");
            if (point == temppaper.id) {
                if (temppaper.target) {
                    System.out.println(papercounter);
                    break;
                }
                papercounter++;
                continue;
            } else {
                list.add(temppaper.id);
                que.offer(temppaper);
            }
            cycle++;
            // System.out.println(cycle);
            System.out.println(_size);
            if (cycle == _size) {
                System.out.println("잡앗다" + point);
                point = Collections.max(list);
                list = new ArrayList<>();
                System.out.println("잡앗다" + que.size());
                _size = que.size();
                System.out.println(_size);
                cycle = 0;
            }

        }

    }

    public static class Paper {
        public int id;
        public boolean target = false;

        public Paper(int id) {
            this.id = id;
        }

    }

}
