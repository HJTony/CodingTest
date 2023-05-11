package BaekJoonLecture.bruteforce.permutation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B10819 {
    static int n;
    static int[] a;

    static int ans = Integer.MIN_VALUE;
    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        do {
            check(a);

        }while( go(a) !=null );
        System.out.println(ans);
    }

    private static void check(int[] a) {
        int sum=0;
        for(int i=0;i<n-1;i++) {
            sum+= Math.abs(a[i]-a[i+1]);
        }
        if(ans < sum) ans = sum;
    }

    private static int[] go(int[] a) {
        int index = 0;
        int last = 0;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                index = i + 1;
                break;
            }
        }
        //if(index == c.length-1) 첫번째순열
        if (index == 0) {
            return null;
        }
        last = index - 1;
        int j = a.length - 1;
        for (int i = index; i < a.length; i++) {
            if (a[last] >= a[i]){
                j = i - 1;
                break;
            }
        }

        int t = a[last];
        a[last] = a[j];
        a[j] = t;

        for (int i = index, k = a.length - 1; i < k; i++, k--) {
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }
        return a;
    }
}
