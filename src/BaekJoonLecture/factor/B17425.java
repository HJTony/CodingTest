package BaekJoonLecture.factor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B17425 {
    static int MAX = 1000000;
    static long[] ans = new long[MAX+1];
    static long[] d = new long[MAX+1];
    public static void test() throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        for(int i=1;i<=MAX;i++) {
            ans[i] = 1;
        }

        for(int i=2;i<=MAX;i++) {
            for(int j=1;i*j<=MAX;j++) {
                ans[i*j] +=i;
            }
        }

        for(int i=1;i<=MAX;i++) {
            d[i] = d[i-1] + ans[i];
        }


        int tc = scanner.nextInt();
        for(int i=0;i<tc;i++) {
            int n = scanner.nextInt();
            System.out.println(d[n]);
        }
    }
}
