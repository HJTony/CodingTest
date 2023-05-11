package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//이친수
//0으로 시작하지 않고 1이 연속으로 2번 오지 않는 수
//n자리로 만들 수 있는 이친수 구하기
public class B2193 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] d = new long[n + 1][2];
        d[1][0] = 0;
        d[1][1] = 1;
        for (int i = 2; i <= n;i++) {
            d[i][0] = d[i-1][1] + d[i-1][0];
            d[i][1] = d[i-1][0];
        }
        System.out.println(d[n][0]+d[n][1]);
    }
}
