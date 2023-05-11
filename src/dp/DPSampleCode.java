package dp;

public class DPSampleCode {
    int n;
    int[][] board;
    int[][] cache;

    public boolean jump(int y, int x) {
        //기저사례 : 게임판을 나간경우
        if (y >= n || x >= n) return false;

        //기저사례 : 게임판 마지막을 도달한 경우
        if ((y == (n - 1)) && (x == (n - 1))) return true;

        int jumpSize = board[y][x];
        return jump(y, x + jumpSize) || jump(y + jumpSize, x);
    }

    public boolean jumpWithMemorization(int y, int x) {
        if (y >= n || x >= n) return false;
        if ((y == (n - 1)) && (x == (n - 1))) return true;

        int ret = cache[y][x];
        if (ret != -1) return ret == 1;

        int jumpSize = board[y][x];

        return jumpWithMemorization(y, x + jumpSize) || jumpWithMemorization(y, x + jumpSize);
    }

}
