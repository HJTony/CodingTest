package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//연속합2
public class B13398 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            dp[i] = a[i];
            dp2[i] = a[i];
        }

        for(int i=1;i<n;i++) {
            if(dp[i-1] + a[i] > dp[i]) dp[i] = dp[i-1] + dp[i];
        }

        for(int i=n-2;i>=0;i--) {
            if(dp2[i+1] + a[i] > dp2[i]) dp2[i] = dp2[i+1] + dp2[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n-1;i++) {
            int count = dp[i-1] + dp2[i+1];
            if(ans < count) ans = count;
        }
        for(int i=0;i<n;i++) {
            if(ans < dp[i]) ans = dp[i];
        }
        System.out.println(ans);
    }
}
