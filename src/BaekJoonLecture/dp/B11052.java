package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//카드 구매하기
public class B11052 {
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = scanner.nextInt();
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (d[i] < d[i - j] + p[j]) {
                    d[i] = d[i - j] + p[j];
                }
            }
        }
        System.out.println(d[n]);
    }

}
