import java.util.ArrayList;

public class PathFinding {
    static int[][] A = {
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1}
    };

    static ArrayList<String> answerList = new ArrayList<>();
    static boolean[][] visited = new boolean[A.length][A[0].length];

    private static void dfs(int row, int col) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length) return;
        if (A[row][col] != 1 || visited [row][col]) return;

        visited[row][col] = true;
        answerList.add("A[" + row + "][" + col + "]");

        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }

    public static void main(String[] args) {
        visited = new boolean[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(i, j);
                    System.out.println(answerList);
                    return;
                }
            }
        }
    }
}
