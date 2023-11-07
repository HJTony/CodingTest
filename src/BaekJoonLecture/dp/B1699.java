package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//제곱수의 합
public class B1699 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
            d[i] = i;
            for (int j=1; j*j <= i; j++) {
                if (d[i] > d[i-j*j] + 1) {
                    d[i] = d[i-j*j] + 1;
                }
            }
        }
        System.out.println(d[n]);
    }

}
