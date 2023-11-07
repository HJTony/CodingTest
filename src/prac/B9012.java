package prac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tc; i++) {
            String input = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean ok = true;
            for(int j=0;j<input.length();j++) {
                if(input.charAt(j) == '(') {
                    stack.push('(');
                }
                if (input.charAt(j) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        ok=false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                ok = false;
            }
            if(ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
