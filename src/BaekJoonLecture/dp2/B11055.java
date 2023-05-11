package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//가장 큰 증가하는 부분수열
public class B11055 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            d[i] = a[i];
            for(int j=0;j<n-1;j++) {
                if(a[j] < a[i] && d[i] < d[j] + a[i])
                    d[i] = d[j] + a[i];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }
}
