package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//가장 긴 바이토닉 수열
public class B11054 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a= new int[n];
        int[] up = new int[n];
        int[] down = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
            up[i] = 1;
            down[i] = 1;
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(a[j] < a[i] && up[i] < up[j] + 1) {
                    up[i] = up[j] + 1;
                }
            }
        }

        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>i;j--) {
                if(a[j] < a[i] && down[i] < down[j] + 1) {
                    down[i] = down[j] + 1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(ans < up[i] + down[i]) ans = up[i] + down[i];
        }

        System.out.println(ans-1);
    }

}
