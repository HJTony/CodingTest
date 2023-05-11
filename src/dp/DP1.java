package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DP1 {
    static int count = 0;

    private static int getN(int N) {
        if (N == 1)
            return N;
        count++;
        if (N % 3 == 0)
            N /= 3;
        else if (N % 2 == 0)
            N /= 2;
        else
            N -= 1;

        return getN(N);
    }

    public void dp1Start() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();


        N = getN(N);
        System.out.println(count);

    }
}
