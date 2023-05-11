package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//가장 긴 증가하는 부분 수열
public class B11053 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
            d[i] = 1;
        }

        for(int i=0;i<n;i++) {
            for(int j=i;j>=0;j--) {
                if(a[i] > a[j] && d[i] <= d[j]) d[i] = d[j] + 1;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            if (ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }

}
