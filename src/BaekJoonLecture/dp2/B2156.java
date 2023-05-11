package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//포도주 시식
public class B2156 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[][] d = new int[n][3];

        for(int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
        }
        d[0][0] = 0; d[0][1]=a[0]; d[0][2]=a[0];
        for(int i=1;i<n;i++) {
            d[i][0] = Math.max(d[i-1][2], Math.max(d[i-1][1], d[i-1][0]));
            d[i][1] = d[i-1][0] + a[i];
            d[i][2] = d[i-1][1] + a[i];
        }

        System.out.println(Math.max(d[n-1][0], Math.max(d[n-1][1], d[n-1][2])));
    }

}
