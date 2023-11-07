package BaekJoonLecture.simulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Gear {
    private int[] nums = new int[8];

    public void leftLotation() {

    }
    public void rightLotation() {

    }
    public void doLotation(int direction) {
        if(direction == 1) {
            this.rightLotation();
        } else this.leftLotation();
    }
    public int getPoint() {
        return 0;
    }
    public int getLeftLink(){return nums[7];}
    public int getRightLink(){return nums[2];}
}

class GearManager {
    private Gear[] gears = new Gear[4];
    private int[] getLinking() {
        int[] links = new int[3];
        if(gears[0].getRightLink() == gears[1].getLeftLink()) links[0] = 0;
        else links[0] = 1;
        if(gears[1].getRightLink() == gears[2].getLeftLink()) links[1] = 0;
        else links[1] = 1;
        if(gears[2].getRightLink() == gears[3].getLeftLink()) links[2] = 0;
        else links[2] = 1;
        return links;
    }
    public void doLotation(int gearNum, int direction) {
        int[] links = this.getLinking();
        switch (gearNum) {
            case 1 :
                //1번 돌리기
                break;
            case 2:

        }
    }
}

public class B14891 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("test/testInput"));
        Scanner scanner = new Scanner(System.in);
        GearManager manager = new GearManager();
        int i = 0;
        manager.doLotation(i, 1);
    }

}
