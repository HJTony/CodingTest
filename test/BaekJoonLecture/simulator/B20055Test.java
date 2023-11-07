package BaekJoonLecture.simulator;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static BaekJoonLecture.simulator.B20055.*;

public class B20055Test extends TestCase {

    @Test
    public void test() {
        n=5;
        for(int i=0;i<5;i++) {
            on.add(false);
        }
        belt.add(0);
        belt.add(1);
        belt.add(2);
        belt.add(3);
        on.set(0,true);
        on.set(4,true);
        System.out.println(on);
        rotate();
        System.out.println(on);
    }
    @Test
    public void test2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.set(3,1);

        System.out.println(list);
    }
}