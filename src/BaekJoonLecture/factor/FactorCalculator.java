package BaekJoonLecture.factor;

import java.io.*;

public class FactorCalculator {
    public void functionStart() throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String read = bufferedReader.readLine();

        factorCalc(Integer.parseInt(read));

    }

    public void factorCalc(int num) {
        for(int i=1;i<=num;i++) {
            if(num%i==0)
                System.out.print(i+" ");
        }
    }
}
