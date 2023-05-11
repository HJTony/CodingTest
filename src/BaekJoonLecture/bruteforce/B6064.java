package BaekJoonLecture.bruteforce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B6064 {

    public static void test() throws FileNotFoundException {

        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();

        for (int t = 0; t < tc; t++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            x-=1;
            y-=1;
            boolean ok = false;
            for(int i=0;i*m+x<m*n;i++) {
                if((i*m+x)%n == y)
                {
                    System.out.println(i*m+x+1);
                    ok=true;
                    break;
                }
            }
            if(!ok)
                System.out.println(-1);
        }
    }
}
