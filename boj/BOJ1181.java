// 문제 링크 : https://www.acmicpc.net/problem/1181

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int n;
    static String[] words;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        for (int i = 0; i < n; i++){
            words[i] = br.readLine();
        }
    }

    private static void solve() throws IOException {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o1.length() - o2.length();
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
            if (i > 0 && words[i-1].equals(words[i]))
                continue;
            bw.write(words[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

}

