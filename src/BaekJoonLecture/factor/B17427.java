package BaekJoonLecture.factor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//약수의 합 2
public class B17427 {

    public static int test(int N) throws IOException {
//        System.setIn(new FileInputStream("test/testInput"));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String strN = bf.readLine();
        long now = System.currentTimeMillis();

//        int N = Integer.parseInt(strN);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += factorCalc2(i);
        }
//        System.out.println(result);
        long end = System.currentTimeMillis() - now;
//        System.out.println(end);
        return result;
    }

    public static int factorCalc(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count += i;
        }
        return count;
    }

    public static int factorCalc2(int num) {
        int d = (int) Math.sqrt(num);
        int count = 0;
        boolean isSqrt = (d * d) == num;
        for (int i = 1; i <= d; i++) {
            if (num % i == 0) {
                count += i;
                if (!(isSqrt && i == d))
                    count += num / i;
            }
        }
        return count;
    }

    public static int factorCalc3(int num) {
        int count =0;
        for(int i=1;i<=num;i++) {
            count+=i*(num/i);
        }
        return count;
    }

}
