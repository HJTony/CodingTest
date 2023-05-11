package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//2XN 타일링
public class B11726 {
    static int n;
    static int[] d;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = new int[n + 2];
        d[1] = 1;
        d[2] = 2;


        for(int i=3;i<=n;i++) {
            d[i] = d[i-2] + d[i-1];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}