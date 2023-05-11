package BaekJoonLecture.factor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//N의 진짜 약수가 주어지고 N값을 찾는 문제
public class B1037 {
    public void test() throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String strN = bf.readLine();
        String strAn = bf.readLine();

        List<Integer> list = Arrays.stream(strAn.split(" ")).map(Integer::parseInt).toList();
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        arrayList.sort(Comparator.naturalOrder());


        output(arrayList);
    }

    public void output(ArrayList<Integer> list) {
        if(list.size() == 1) {
            System.out.println(4);
        } else {
            System.out.println(list.get(0) * list.get(list.size() - 1));
        }

    }
}
