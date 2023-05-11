package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//가장 긴 감소하는 부분 수열 : 3가지 방법이 있음
public class B11722 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            d[i] = 1;
        }

        for(int i=0;i<n;i++) {
            for(int j=i-1;j>=0;j--) {
                if(a[j] > a[i] && d[i] < d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++ )
            if(ans < d[i]) ans = d[i];
        System.out.println(ans);
    }
}
