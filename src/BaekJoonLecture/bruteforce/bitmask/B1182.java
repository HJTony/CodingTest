package BaekJoonLecture.bruteforce.bitmask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B1182 {
    static int n;
    static int s;
    static int[] a;
    static int ans = 0;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
        }
        go();
    }

    private static void go() {
        for(int i=1;i<(1<<n);i++) {
            int sum =0;
            for(int k=0;k<n;k++) {
                if((i & (1<<k)) !=0) {
                   sum += a[k];
                }
            }
            if(sum == s) {
                ans +=1;
            }
        }
        System.out.println(ans);
    }
}
