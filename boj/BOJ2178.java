// 문제 링크 : https://www.acmicpc.net/problem/2178

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static String[][] maze;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(maze[N-1][M-1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        maze = new String[N][M];
        for (int i = 0 ; i < N; i++) {
            maze[i] = br.readLine().split("");
        }
    }

    // BFS 풀이
    private static void solve() throws IOException {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        boolean[][] checked = new boolean[N][M];

        int startX = 0;
        int startY = 0;
        checked[startX][startY] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            checked[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!checked[nx][ny] && maze[nx][ny].equals("1")) {
                        q.add(new int[]{nx, ny});
                        maze[nx][ny] = Integer.toString(Integer.parseInt(maze[x][y]) + 1);
                    }
                }
            }
        }
    }
}
