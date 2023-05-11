package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class B2309 {
    static int[] list = new int[9];
    static int[] out = new int[2];

    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            list[i] = scanner.nextInt();
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                boolean result = cal(i, j);
                if (result) {
                    out[0] = i;
                    out[1] = j;
                    break;
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : list) {
            arrayList.add(i);
        }
        int a = arrayList.get(out[0]);
        int b = arrayList.get(out[1]);
        arrayList.sort(Comparator.naturalOrder());
        for (int i : arrayList) {
            if (i == a| i == b) continue;
            System.out.println(i);
        }
    }

    private static boolean cal(int i, int j) {
        int count = 0;
        for (int k = 0; k < 9; k++) {
            if (k == i | k == j) continue;
            count += list[k];
        }
        return (count == 100);
    }
}
