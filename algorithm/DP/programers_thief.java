package algorithm.DP;

import java.util.Arrays;

public class programers_thief {

    static int[][] board = new int[6][4];
    static boolean[][] visited = new boolean[6][4];
    static int M;
    static int N;
    static int max;

    public static void main(String[] args) {

        int[][] picture = {{1,0,0}}
    }


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m;
        N = n;
        int[] answer = new int[2];
        board = picture;
        Arrays.fill(visited, false);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j, 0));
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int dfs(int y, int x, int cnt) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                // 다음 구간이 현재와 같을때
                if (board[ny][nx] == board[y][x] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    cnt = dfs(ny, nx, ++cnt);
                }
            }
        }
        return cnt;
    }

}
