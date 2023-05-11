package BaekJoonLecture.bruteforce.bitmask;

import java.io.*;

//        add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//        remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//        check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//        toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//        all: S를 {1, 2, ..., 20} 으로 바꾼다.
//        empty: S를 공집합으로 바꾼다.
public class B11723 {
    private static int i = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("test/testInput"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        for (int i = 0; i < Integer.parseInt(n); i++) {
            String c = br.readLine();
            go(c, bw);
        }
        bw.flush();
        bw.close();
    }

    private static void go(String c, BufferedWriter bw) throws IOException {
        String[] str = c.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        String command = str[0];
        int arg = 0;
        if (str.length > 1)
            arg = Integer.parseInt(str[1]);

        switch (command) {
            case "add" -> i = i | (1 << arg);
            case "remove" -> i = i & ~(1 << arg);
            case "check" -> {
                if ((i & (1 << arg)) != 0) {
                    bw.write(stringBuilder.append(1).append("\n").toString());
                } else {
                    bw.write(stringBuilder.append(0).append("\n").toString());
                }
            }
            case "toggle" -> i = i ^ (1<<arg);
            case "all" -> i = (1 << 21) - 1;
            case "empty" -> i = 0;
        }
    }
}