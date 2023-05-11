package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//오르막수
public class B11057 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] d = new long[n+1][10];
        for(int i=0;i<10;i++) d[1][i]=1;


        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                for(int k=0;k<=j;k++) {
                    d[i][j] += d[i-1][k];
                    d[i][j]%=10007;
                }
            }
        }

        long ans = 0;
        for(int i=0;i<10;i++) {
            ans += d[n][i];
            ans%=10007;
        }
        System.out.println(ans);
    }
}
