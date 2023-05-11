package Algo;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FormatChangeTest {
    @Test
    public void change() throws IOException {
        Path p = Paths.get("test/mainInput");
        List<String> list = Files.readAllLines(p);


        int index = 0;
        for (String s : list) {
            if (s.contains("test")) {
                break;
            }
            index++;
        }
        File f = new File("test/MainOutput");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (String s : list) {
            if (s.contains("test")) {
                s = s.replace("test", "main");
            }
            if(s.contains("class")) {
                s = "public class Main {";
            }
            if(s.contains("package")) {
                s="";
            }
            if(s.contains("setIn"))
                s="";
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }

}
