package BaekJoonLecture.bruteforce;

import java.io.*;

public class B15652 {
    static int[] a;
    static StringBuilder sb = new StringBuilder();
    public static void test(String[] args) throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] sp = line.split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        a = new int[m];

        go(0, 1, n,m);

        bw.write(sb.toString());
        bw.flush();
    }
    private static void go(int index, int start, int n, int m) {
        if (index == m) {
            for (int i : a) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=n;i++) {
            a[index] = i;
            go(index+1, i, n, m);
        }
    }
}
