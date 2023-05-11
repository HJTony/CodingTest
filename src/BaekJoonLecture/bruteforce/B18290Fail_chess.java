package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class B18290Fail_chess {
    static ArrayList<Integer> oddList = new ArrayList<>();
    static ArrayList<Integer> evenList=  new ArrayList<>();
    static int ans = -210999999;

    public static void test(String[] args) throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);
        int[] nums = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            nums[i] = scanner.nextInt();
        }

        if (n % 2 == 1) {
            for (int i = 0; i < n * m; i++) {
                if (i % 2 == 0) {
                    evenList.add(nums[i]);
                }

                else
                    oddList.add(nums[i]);
            }

        } else {
            for (int i = 0, j = 0; i < n * m; i += n, j++) {
                if (j % 2 == 0)
                    for (int l = i + 1; l < i + n; l += 2)
                        evenList.add(nums[l]);
                else
                    for (int l = i; l < i + n; l += 2)
                        evenList.add(nums[l]);
            }

            for (int i = 0, j = 0; i < n * m; i += n, j++) {
                if (j % 2 == 0)
                    for (int l = i; l < i + n; l += 2)
                        oddList.add(nums[l]);
                else
                    for (int l = i + 1; l < i + n; l += 2)
                        oddList.add(nums[l]);
            }

        }
        go(0, 0, oddList.size(), k, oddList, 0);
        go(0, 0, evenList.size(), k, evenList, 0);
        System.out.println(ans);

    }

    private static void go(int index, int start, int n, int m, ArrayList<Integer> list, int count) {
        if (index == m) {
            ans = Math.max(ans, count);
            return;
        }
        for (int i = start; i < n; i++) {
            count += list.get(i);
            go(index + 1, i + 1, n, m, list, count);
            count -= list.get(i);
        }
    }
}
