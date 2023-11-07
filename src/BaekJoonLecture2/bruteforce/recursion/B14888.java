package BaekJoonLecture2.bruteforce.recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B14888 {

    static int n;
    static int[] a;
    static boolean[] c;
    static int[] cal;//덧셈,뺄셈,곱셈,나눗셈의 수
    static ArrayList<Integer> calList = new ArrayList<>();
    static int[] b;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        cal = new int[4];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            cal[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < cal[i]; j++) {
                calList.add(i);
            }
        }
        b = new int[calList.size()];
        c = new boolean[calList.size()];

        go(0);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void go(int index) {
        if(calList.size() == index) {
            System.out.println(Arrays.toString(b));
            calculate();
            return;
        }
        for(int i=0;i<calList.size();i++) {
            if(c[i]) continue;
            c[i] = true;
            b[index] = calList.get(i);
            go(index + 1);
            c[i] = false;
        }
    }

    public static void calculate() {
        int v = getValue();
        if(MAX < v) MAX = v;
        if(MIN > v) MIN = v;
    }
    public static int getValue() {
        int[] temp = Arrays.copyOf(a, a.length);
        for(int i=0;i<a.length-1;i++) {
//
            if(b[i] == 0) temp[i+1] = temp[i] + temp[i+1];
            if(b[i] == 1) temp[i+1] = temp[i] - temp[i+1];
            if(b[i] == 2) temp[i+1] = temp[i] * temp[i+1];
            if(b[i] == 3) temp[i+1] = temp[i] / temp[i+1];
        }
        return temp[a.length-1];
    }
}
