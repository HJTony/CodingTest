package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//2*N 타일링 2 (총 3가지 경우의 수를 갖는 타일 구성하기)
public class B11727 {
    static int n;
    static int[] d;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = new int[n + 2];
        d[1] = 1;
        d[2] = 3;


        for(int i=3;i<=n;i++) {
            d[i] = 2*d[i-2] + d[i-1];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}