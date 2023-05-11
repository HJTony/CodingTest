package BaekJoonLecture.bruteforce.permutation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B6603 {
    static int k = 6;
    static int n;
    static int[] a;
    static int[] temp = new int[6];
    static boolean[] c;

    public static void mainWithCombination(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        do {
            n = scanner.nextInt();
            a = new int[n];
            c = new boolean[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            combination(0, 0);
            System.out.println();
        } while (n != 0);

    }

    public static void mainWithPermutation(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        do {
            n = scanner.nextInt();
            if(n==0) break;
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            //list.add 0 or 1
            //do-while next_permutation list
            //list to map -> sout a
            int count0 = n - 6;
            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                if (i < 6) list[i] = 1;
                else list[i] = 0;
//                if(i < count0) list[i] = 0;
//                else list[i] = 1;
            }
            do {
                for (int i = 0; i < n; i++) {
                    if (list[i] == 1)
                        System.out.print(a[i] + " ");
                }
                System.out.println();
            } while (prev_permutation(list));


            System.out.println();
        } while (n != 0);
    }

    private static boolean prev_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] <= a[i]) i--;
        if (i == 0) return false;
        int j = a.length - 1;
        while (a[i - 1] <= a[j]) j--;
        int t = a[i - 1];
        a[i - 1] = a[j];
        a[j] = t;

        for (int index = i, last = a.length - 1; index < last; index++, last--) {
            int temp = a[index];
            a[index] = a[last];
            a[last] = temp;
        }
        return true;
    }


    private static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i == 0) return false;
        int j = a.length - 1;
        while (a[i - 1] >= a[j]) j--;
        int t = a[i - 1];
        a[i - 1] = a[j];
        a[j] = t;

        for (int index = i, last = a.length - 1; index < last; index++, last--) {
            int temp = a[index];
            a[index] = a[last];
            a[last] = temp;
        }
        return true;
    }

    private static void combination(int start, int index) {
        if (index == k) {
            for (int i : temp) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (c[i]) continue;
            temp[index] = a[i];
            c[i] = true;
            combination(i + 1, index + 1);
            c[i] = false;
        }
    }
}
