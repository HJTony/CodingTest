package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B9095 {
    static int n;
    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int tc = 0; tc<t;tc++) {
            n = scanner.nextInt();
            System.out.println(go(0,n));
        }
    }
    private static int go( int sum, int goal) {
        if(goal == sum) return 1;
        if(sum>goal) return 0;
        int now =0;
        now += go( sum+1,goal);
        now += go( sum+2,goal);
        now += go( sum+3,goal);
        return now;
    }
    public static void test2() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        int[] dp = new int[11];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<11;i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int i = 0;i<tc;i++) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }

}