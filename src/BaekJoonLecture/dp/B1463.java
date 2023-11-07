package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//        정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//        X가 3으로 나누어 떨어지면, 3으로 나눈다.
//        X가 2로 나누어 떨어지면, 2로 나눈다.
//        1을 뺀다.
//        정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
public class B1463 {
    static int n;
    static int[] d;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = new int[n+1];
        System.out.println(goTopDown(n));
    }

    private static int goTopDown(int n) {
        if(n==1) return 0;
        if(d[n] > 0) return d[n];

        d[n] = goTopDown(n-1) + 1;
        if(n%2==0) {
            int t = goTopDown(n/2) + 1;
            if(d[n] > t) d[n] = t;
        }

        if(n%3==0) {
            int t = goTopDown(n/3) + 1;
            if(d[n] > t) d[n] = t;
        }
        return d[n];
    }
    private static void goBottomUp() {
        int[] dp = new int[n+1];
        dp[1]=0;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + 1;
            if(i%2==0 && dp[i] > dp[i/2] + 1)
                dp[i] = dp[i/2] + 1;
            if(i%3==0 && dp[i]  > dp[i/3] +1)
                dp[i] = dp[i/3] + 1;
        }
        System.out.println(dp[n]);
    }
}
