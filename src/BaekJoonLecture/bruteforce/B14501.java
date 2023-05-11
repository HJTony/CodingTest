package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B14501 {
    static int n;
    static int ans = 0;
    static int[] t = new int[15];
    static int[] p = new int[15];

    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        go(0, 0);
        System.out.println(ans);
    }

    private static void go(int day, int sum) {
        if (day == n + 1) {
            if (ans < sum) ans = sum;
            return;
        }
        if (day > n) return;

        for(int i=0;i<n;i++) {
            go(day + t[i], sum + p[i]);
            go(day+1, sum);
        }

    }
}
