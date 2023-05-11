package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B1476 {
    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        //(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

        Year actual = new Year(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        Year y = new Year(1, 1, 1);
        int result = 1;
        while(!actual.compare(y)) {
            y.nextYear();
            result++;
        }
        System.out.println(result);
    }
}

class Year {
    private int E;
    private int S;
    private int M;

    public boolean compare(Year y) {
        return (this.E==y.E) && (this.S == y.S) && (this.M == y.M);
    }
    public Year(int e, int s, int m) {
        E = e;
        S = s;
        M = m;
    }

    public void nextYear() {
        this.E++;
        this.S++;
        this.M++;
        if (this.E == 16) E -= 15;
        if (this.S == 29) S -= 28;
        if (this.M == 20) M -= 19;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

}
