package BaekJoonLecture.GCDorLCM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B2609 {
    public static void test() throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int g = GCDCal.euclidRecur(a, b);

        int aperg = a/g;
        int bperg = b/g;

        int l = g*aperg*bperg;

        System.out.println(g);
        System.out.println(l);

    }

}
