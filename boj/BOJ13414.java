// 문제 링크 : https://www.acmicpc.net/problem/13414

import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int L;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedHashSet<String> students = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        String[] temp = br.readLine().split(" ");

        K = Integer.parseInt(temp[0]);
        L = Integer.parseInt(temp[1]);

        for(int i=0; i< L; i++) {
            String num = br.readLine();
            if(students.contains(num)) students.remove(num);
            students.add(num);
        }
    }

    private static void solve() throws IOException {
        for(String studentId : students) {
            if(K <= 0)
                break;
            bw.write(studentId + "\n");
            K--;
        }

        bw.flush();
        bw.close();
    }
}
