package BaekJoonLecture.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
//1,2,3 더하기
public class B9095 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4;i<11;i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        for(int i=0;i<t;i++) {
            int n = scanner.nextInt();
            System.out.println(d[n]);
        }
    }

}
