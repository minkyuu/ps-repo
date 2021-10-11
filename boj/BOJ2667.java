// 문제 링크 : https://www.acmicpc.net/problem/2667

import java.util.*;

public class Main {

    static int N;
    static String[][] map;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][] visited;
    static int houseNum;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            map[i] = sc.nextLine().split("");
        }
    }

    private static void solve() {
        ArrayList<Integer> answer = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("1") && !visited[i][j]){
                    result++;
                    houseNum = 0;
//                    dfs(i, j, houseNum);
                    bfs(i, j, houseNum);
                    answer.add(houseNum);
                }
            }
        }
        System.out.println(result);
        answer.stream().sorted().forEach(x -> System.out.println(x));
    }

    private static void bfs(int x, int y, int count) {
        visited[x][y] = true;
        houseNum = ++count;
        Queue<int[]> q = new LinkedList<>();
        int[] temp = new int[]{x, y};
        q.add(temp);

        while(!q.isEmpty()){
            temp = q.poll();
            x = temp[0];
            y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N)
                    if (map[nx][ny].equals("1") && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        houseNum++;
                        q.add(new int[]{nx, ny});
                    }
            }
        }
    }

    private static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        houseNum = ++count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny <N)
                if (map[nx][ny].equals("1") && !visited[nx][ny])
                    dfs(nx, ny, houseNum);
        }
    }
}
