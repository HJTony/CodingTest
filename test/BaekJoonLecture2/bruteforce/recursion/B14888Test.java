package BaekJoonLecture2.bruteforce.recursion;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class B14888Test extends TestCase {
    static int[] b;
    static boolean[] c;
    @Test
    public void test() {
        int[] a = {1,1,2,3,4};
        b = new int[a.length];
        c = new boolean[a.length];
        go(a, 0);
    }
    public void go(int[] a, int index) {
        if(a.length == index) {
            System.out.println(Arrays.toString(b));
            return;
        }
        for(int i=0;i<a.length;i++) {
            if(c[i]) continue;
            c[i] = true;
            b[index] = a[i];
            go(a, index + 1);
            c[i] = false;
        }
    }

    @Test
    public void test2() {
        int a = -11;
        int b = 3;
        System.out.println(a/b);
    }

}