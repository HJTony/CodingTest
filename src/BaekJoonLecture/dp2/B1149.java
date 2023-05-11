package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//RGB 거리
public class B1149 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] d = new int[n][3];
        int[][] a = new int[n][3];
        for(int i=0;i<n;i++) {
            for(int j=0;j<3;j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        d[0][0] = a[0][0];
        d[0][1] = a[0][1];
        d[0][2] = a[0][2];

        for(int i=1;i<n;i++) {
            d[i][0] = Math.min(d[i-1][1] + a[i][0], d[i-1][2] + a[i][0]);
            d[i][1] = Math.min(d[i-1][2] + a[i][1], d[i-1][0] + a[i][1]);
            d[i][2] = Math.min(d[i-1][1] + a[i][2], d[i-1][0] + a[i][2]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<3;i++)
            if(ans > d[n-1][i]) ans = d[n-1][i];
        System.out.println(ans);
    }
}
