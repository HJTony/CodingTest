package Algo;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BaekJoonLectureTest {

    @Test
    public void problem() throws IOException {
//        B6603.test(null);
        int n = 10;
        int [] d = new int[11];
        d[0] =3;
        for(int i=1;i<11;i++) {
            d[i] = 7*d[i-1];
        }
    }



}
