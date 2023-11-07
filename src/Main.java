import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] d = new int[1_001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        for(int i=3;i<=1_000;i++) {
            d[i] = d[i-1] + 2*d[i-2];
        }
        System.out.println(d[n]);
    }

}
