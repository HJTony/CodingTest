package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B1748 {
    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = n;
        int r=0;
        while(!(t==0)) {
            t/=10;
            r++;
        }
        double sum=0;
        for(int i=0;i<r;i++) {
            if(i+1==r) {
                sum+= (i+1)*(n - Math.pow(10,i) + 1);
            }
            else {
                sum += 9*Math.pow(10,i)*(i+1);
            }
        }
        System.out.println((int)sum);
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = 0;

        for(int start = 1, len=1;start<=n;start*=10,len++) {
            int end = start*10 - 1;
            if(end > n) {
                end = n;
            }
            ans += (end - start + 1) * len;
        }
        System.out.println(ans);
    }

}
