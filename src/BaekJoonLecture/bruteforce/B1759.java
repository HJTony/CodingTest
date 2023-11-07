package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1759 {
    static int size, total;
    static String[] ans;
    static boolean[] c;
    static String[] str;
    static Character[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void test(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        total = scanner.nextInt();
        ans = new String[size];
        c = new boolean[total];
        scanner.nextLine();
        str = scanner.nextLine().split(" ");
        Arrays.sort(str, Comparator.naturalOrder());
        go(0, 0);
    }

    private static void go(int index, int start) {
        if (index == size) {
            if (isOk()){
                for(int m = 0;m<size;m++) {
                    System.out.print(ans[m]);
                }
                System.out.println();
            }

            return;
        }
        for (int i = start; i < total; i++) {
            if (c[i]) continue;
            ans[index] = str[i];
            c[i] = true;
            go(index + 1, i + 1);
            c[i] = false;

        }
    }

    private static boolean isOk() {
        int aCount = 0;
        int bCount = 0;
        for (String s : ans) {
            for (char c : vowels) {
                if (c == s.charAt(0)) {
                    aCount++;
                    break;
                }
            }
        }
        bCount = ans.length - aCount;
        if (aCount >= 1 && bCount >= 2) return true;
        else return false;
    }
}
