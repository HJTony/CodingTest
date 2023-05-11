import BaekJoonLecture.bruteforce.B1795;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SimpleTest {
    @Test
    public void mapTest() {
        HashMap<Integer, Integer> map = new HashMap<>();
    }

    @Test
    public void math() throws FileNotFoundException {

        System.out.println(isOk());
    }
     Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
    String[] ans = {"a", "b", "c"};
    public  boolean isOk() {
        int aCount = 0;
        int bCount = 0;
        for (String s : ans) {
            for (char c : vowels) {
                if (c == s.charAt(0)) {
                    aCount++;
                    break;
                }
            }
        }
        bCount = ans.length - aCount;
        if (aCount >= 1 && bCount >= 2) return true;
        else return false;
    }
    @Test
    public void test() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test/testInput")));
        for (int i = 6; i < 1000000; i++)
            if (i % 2 == 0)
                bw.write(i + "\n");
        bw.flush();
    }

    @Test
    public void bwTest() throws IOException {
        System.out.println(Math.pow(2,100));
    }

    @Test
    public void listTest() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(2); a1.add(3);
        list.add(a1);
        list.get(0);
    }
}
