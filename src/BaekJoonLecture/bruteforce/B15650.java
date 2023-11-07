package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


//순서로 이외에 선택으로도 해결할 수 있다.
public class B15650 {
    static boolean[] c;
    static int[] a;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        a = new int[m];
        c = new boolean[n];

        getCom(0, n, m, 0);
//        go(0, 0, n, m);
    }

    private static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        if(index > n) return;
        a[selected] = index;
        go(index + 1, selected + 1, n, m);
        go(index + 1, selected, n, m);
    }

    private static void getCom(int index, int n, int m, int start) {

        if (index == m) {
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            a[index] = i;
            getCom(index + 1, n, m, i + 1);
        }
    }

}
