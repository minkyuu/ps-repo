// 문제 링크 : https://www.acmicpc.net/problem/1260

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;
    static int M;
    static int startV;


    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            N = Integer.parseInt(st.nextToken()) + 1;
            M = Integer.parseInt(st.nextToken());
            startV = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i < N; i++) {
            graph.get(i).sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
        }

    }

    private static void solve() {
        dfs(new boolean[N], startV);
        System.out.println();
        bfs(new boolean[N], startV);
    }

    private static void dfs(boolean[] visited, int startV) {
        System.out.print(startV + " ");
        visited[startV] = true;

        for (int i = 0; i < graph.get(startV).size(); i++) {
            int now = graph.get(startV).get(i);
            if (!visited[now]) {
                dfs(visited, now);
            }
        }
    }

    // queue 사용
    private static void bfs(boolean[] visited, int startV) {
        Queue<Integer> q = new LinkedList<>();
        visited[startV] = true;
        q.add(startV);

        while(!q.isEmpty()){
            int start = q.poll();
            System.out.print(start + " ");

            for (int i = 0; i < graph.get(start).size(); i++) {
                int now = graph.get(start).get(i);
                if (!visited[now]){
                    visited[now] = true;
                    q.add(now);
                }
            }
        }
    }


}

