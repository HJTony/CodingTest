package dp;

public class DPPattern {
    int[][] memory;
    public int someFunction(int i, int j) {
        // 기저 사례를 처음에 처리한다.
        int caseCondition=1;
        if(caseCondition!=0) return 1;

        //메모이제이션된 값이 있으면 리턴한다.
        int ret = memory[i][j];
        if(ret != -1) return ret;

        //로직을 계산한다.
        /*

         */
        return ret;
    }
}
