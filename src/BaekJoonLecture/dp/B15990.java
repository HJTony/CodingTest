package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//1+2+3 더하기 문제 2
//마지막에 중복으로 숫자가 나열되면 안되는 조건 추가
public class B15990 {
    static long mod = 1000000009L;
    static int N = 100000;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        long[][] d = new long[N+1][4];
        d[1][1]=1; d[1][2]=0; d[1][3]=0;
        d[2][1]=0; d[2][2]=1; d[2][3]=0;
        d[3][1]=1; d[3][2]=1; d[3][3]=1;

        for(int i=4;i<=N;i++) {
            d[i][1] = d[i-1][2] + d[i-1][3];
            d[i][2] = d[i-2][1] + d[i-2][3];
            d[i][3] = d[i-3][2] + d[i-3][1];
            d[i][1]%=mod;
            d[i][2]%=mod;
            d[i][3]%=mod;
        }
        for(int i=0;i<t;i++) {
            int n = scanner.nextInt();
            long ans = (d[n][1]+d[n][2]+d[n][3])%mod;
            System.out.println(ans);
        }

    }

}
