// 문제 링크 : https://www.acmicpc.net/problem/1012

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M;
    static int N;
    static int K;
    static boolean[][] visited;
    static int[][] land;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // col
            N = Integer.parseInt(st.nextToken()); // row
            K = Integer.parseInt(st.nextToken()); // lettuce num
            visited = new boolean[N][M];

            land = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                // x : 열 위치 , y : 행 위치
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                land[y][x] = 1;
            }

            solve();
        }
    }

    private static void solve() {
        int result = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++){
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    // bfs
    private static void bfs(int i, int j) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()){
            int[] location = q.poll();
            int x = location[0];
            int y = location[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && land[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }
}

