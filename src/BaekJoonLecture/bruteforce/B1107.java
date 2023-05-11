package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1107 {
    static int MAX = 10000000;
    static boolean[] errNum = new boolean[10];
    static boolean[] isExistNum = new boolean[MAX + 1];
    static int[] existNum = new int[MAX + 1];

    public static void test() throws FileNotFoundException {
//        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int now = 100;
        int moveTo = scanner.nextInt();
        int n = scanner.nextInt();
        if (n == 0) {
            int abs = Math.abs(100 - moveTo);
            System.out.println(Math.min(String.valueOf(moveTo).length(), abs));
            System.exit(0);
        }
        if(n==10) {
            System.out.println(Math.abs(moveTo-100));
            System.exit(0);
        }
        if (moveTo == 100) {
            System.out.println(0);
            System.exit(0);
        }
        scanner.nextLine();
        String[] err = scanner.nextLine().split(" ");
        ArrayList<String> arrayList = new ArrayList<>(List.of(err));
        Arrays.fill(errNum, true);
        Arrays.fill(isExistNum, true);
        Arrays.fill(existNum, -1);
        for (int i = 0; i < 10; i++) {
            if (arrayList.contains(String.valueOf(i)))
                errNum[i] = false;
        }

        for (int i = 0; i <= MAX; i++) {
            if (numberMatch(i))
                continue;
            isExistNum[i] = false;
        }

        for (int i = 0; i <= MAX; i++) {
            if (isExistNum[i])
                existNum[i] = i;
        }

        int near = 0;
        int abs = 0;
        for (int i = 0; i < MAX; i++) {
            if ((moveTo - i) <= MAX && (moveTo - i) >= 0) {
                if (isExistNum[moveTo - i]) {
                    near = moveTo - i;
                    abs = i;
                    break;
                }

            }
            if ((moveTo + i) >= 0 && (moveTo + i) <= MAX) {
                if (isExistNum[moveTo + i]){
                    near = moveTo + i;
                    abs = i;
                    break;
                }

            }
        }
        String countStr = String.valueOf(near);

        int count = countStr.length();
        int ans1 = count + abs;
        int ans2 = Math.abs(moveTo-100);
        int ans = Math.min(ans1, ans2);
//        System.out.println(near);
        System.out.println(ans);
    }

    private static boolean numberMatch(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - '0';
            if (!errNum[index]) {
                return false;
            }
        }
        return true;
    }


}
