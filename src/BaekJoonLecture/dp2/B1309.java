package BaekJoonLecture.dp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//동물원
public class B1309 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] d = new long[n][3];
        d[0][0] = 1;
        d[0][1] = 1;
        d[0][2] = 1;

        for(int i=1;i<n;i++) {
            d[i][0] = d[i-1][0]+d[i-1][1]+d[i-1][2];
            d[i][1] = d[i-1][0]+d[i-1][2];
            d[i][2] = d[i-1][0]+d[i-1][1];
            d[i][0]%=9901;
            d[i][1]%=9901;
            d[i][2]%=9901;
        }
        System.out.println((d[n-1][0] + d[n-1][1] + d[n-1][2])%9901);
    }

}
