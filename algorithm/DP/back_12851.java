package algorithm.DP;

import java.util.*;

public class back_12851 {

    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();
        int end = 200000;
        int cnt = 0;
        int[] load = new int[end];
        Arrays.fill(load, -1); // 수정: load 배열을 -1로 초기화하여 방문하지 않은 상태로 설정

        int min = Integer.MAX_VALUE;
        Queue<Integer> que = new LinkedList<>();
        load[N] = 0; // 수정: 시작 위치의 load를 0으로 설정
        que.offer(N);
        while (!que.isEmpty()) {
            int x = que.poll();
            int[] dx = { x - 1, x + 1, x * 2 };
            if (min < load[x]) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                int nx = dx[i];
                if (nx >= 0 && nx < end) {
                    if (load[nx] != -1 && load[x] + 1 > load[nx]) { // 수정: 이미 방문한 곳이고 현재까지의 이동 횟수가 기존 이동 횟수보다 큰 경우에는 무시
                        continue;
                    }
                    if (nx == K) {
                        min = load[x] + 1; // 수정: 목표 위치에 도달했을 때 최소 시간 업데이트
                        cnt++;
                    }
                    if (load[nx] == -1 || load[nx] >= load[x] + 1) { // 수정: 방문하지 않은 곳이거나 현재까지의 이동 횟수가 더 작은 경우에만 업데이트
                        load[nx] = load[x] + 1;
                        que.offer(nx);
                    }

                }

            }
        }

        System.out.println(min);
        System.out.println(cnt);
    }

}
