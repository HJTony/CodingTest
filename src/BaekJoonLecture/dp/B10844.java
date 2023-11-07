package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//계단 수 구하기 n자리수로 이뤄진 계단 형태의 수열 구하기
//계단 수란 앞의 자리가 -1 또는 +1 로 구성된 형태의 수열
public class B10844 {
    static long mod = 1000000000L;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[][] d = new long[n + 1][10];
        d[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        if (n > 1) {
            for (int i = 2; i < n + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        d[i][j] = d[i - 1][1];
                        continue;
                    }
                    if (j == 9) {
                        d[i][j] = d[i - 1][8];

                        continue;
                    }
                    d[i][j] = d[i - 1][j + 1]+ d[i - 1][j - 1];
                    d[i][j]%=mod;

                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += d[n][i];
        }
        ans%=mod;
        System.out.println(ans);
    }

}
