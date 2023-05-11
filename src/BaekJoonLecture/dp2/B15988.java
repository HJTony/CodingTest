package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//1, 2, 3 더하기 3
public class B15988 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        long[] d = new long[1000001];
        d[1]=1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4;i<1000001;i++) {
            d[i] = d[i-1]+d[i-2]+d[i-3];
            d[i]%=1000000009;
        }
        for(int i=0;i<t;i++) {
            int n = scanner.nextInt();
            System.out.println(d[n]);
        }
    }

}
