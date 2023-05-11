package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//연속 합
public class B1912 {
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
        for(int i=1;i<n;i++) {
            if(d[i-1] > 0) {
                d[i] = d[i-1] + a[i];
            } else d[i] = a[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }
}
