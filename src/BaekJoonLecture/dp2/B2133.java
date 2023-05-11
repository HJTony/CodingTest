package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//타일 채우기 3XN
public class B2133 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i+=2) {
            dp[i] = dp[i-2]*3;
            for(int j=2;j*2<=i;j++) {
                dp[i] += dp[i-2*j]*2;
            }
//            for (int j=i-4; j>=0; j-=2) {
//                d[i] += d[j]*2;
//            }
        }
        System.out.println(dp[n]);
    }

}
