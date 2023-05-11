package BaekJoonLecture.bruteforce.permutation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//다음 순열
//1. 마지막 순열을 찾되, a[i-1] < a[i]를 만족하는 가장 큰 i를 찾는다.
//2. j>=i이면서, a[i-1] < a[j]를 만족하는 가장 큰 j를 찾는다.(값은 가장 작음)
//3. a[i-1] <-> a[j] 스왑
//4. a[i] 부터 순열을 뒤집는다.
public class B10972 {
    static int n;
    static int[] a;

    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
//        for(int i=0;i<n;i++) {
//            a[i] = i+1;
//        }
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (next_permutation(a)) {
            for (int num : a) {
                System.out.print(num + " ");
            }
        } else System.out.println(-1);
    }

    private static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i == 0) return false;
        int j = a.length-1;
        while(a[i-1] >= a[j]) j--;
        int t = a[i-1];
        a[i-1] = a[j];
        a[j] = t;

        for(int index = i, last = a.length-1; index < last; index++,last--) {
            int temp = a[index];
            a[index] = a[last];
            a[last] = temp;
        }
        return true;
    }

}
