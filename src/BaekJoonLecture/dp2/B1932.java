package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//정수 삼각형
public class B1932 {
    static int n;
    static int[][] a;
    static int[][] d;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        a = new int[n][n];
        d = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        d[0][0] = a[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                d[i][j] = d[i-1][j] + a[i][j];
                if(j-1>=0 && d[i][j] < d[i-1][j-1] + a[i][j]) d[i][j] = d[i-1][j-1] + a[i][j];

            }
        }
        int ans = 0;
        for(int i=0;i<n;i++)
            if(ans < d[n-1][i]) ans = d[n-1][i];
        System.out.println(ans);
    }

}

