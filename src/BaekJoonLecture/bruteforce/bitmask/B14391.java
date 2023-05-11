package BaekJoonLecture.bruteforce.bitmask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B14391 {
    static int n;
    static int m;
    static int[][] a;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < (1 << (n * m)); i++) {

            int sum = 0;
            for (int y = 0; y < n; y++) {
                int cur = 0;
                for (int x = 0; x < m; x++) {
                    if ((i & (1 << (y * m + x))) != 0) {
                        cur = cur * 10 + a[y][x];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for (int x = 0; x < m; x++) {
                int cur = 0;
                for (int y = 0; y < n; y++) {
                    if ((i & (1 << (y * m + x))) == 0) {
                        cur = cur * 10 + a[y][x];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            if (ans < sum) ans = sum;
        }
        System.out.println(ans);
    }
}
