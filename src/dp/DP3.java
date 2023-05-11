package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DP3 {

    Integer[] memory;
    public void dp3Start() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        memory = new Integer[N+1];
        memory[0] = 0;
        memory[1] = 1;

        int result;

        result = dp(N);

        System.out.println(result%10007);
    }

    private int dp(int n) {
        /* n의 크기가 1이상일떄에는 세로로 한칸 넣거나, 가로로 한칸 넣거나 할 수 있다.
        세로로 한칸 넣을 때에는 n이 1이 줄어들고, 가로로 넣을 때에는 n이 2칸 줄어든다.

         */
        if(n>1) {
//            memory[n] =
        } else {

        }
        //if(n==1) return memory[1];
        return memory[n];
    }
}
