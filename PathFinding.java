import java.util.*;

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

    static int[][] B = {
            {0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,1,1,0},
            {0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,1,0,0,0,0},
            {1,1,1,1,1,1,1,0,0,0,0},
    };

    static ArrayList<String> answerList = new ArrayList<>();
    static boolean[][] visited = new boolean[A.length][A[0].length];

    private static void dfs(int[][] matrix, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return;
        if (matrix[row][col] != 1 || visited[row][col]) return;

        visited[row][col] = true;
        answerList.add("[" + row + "][" + col + "]");

        dfs(matrix, row - 1, col);
        dfs(matrix, row + 1, col);
        dfs(matrix, row, col - 1);
        dfs(matrix, row, col + 1);
    }

    public static void main(String[] args) {

        visited = new boolean[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    System.out.println(answerList);
                    answerList.clear();
                    break;
                }
            }
        }

        visited = new boolean[B.length][B[0].length];

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] == 1) {
                    System.out.println("B");
                    dfs(B, i, j);
                    System.out.println(answerList);
                    return;
                }
            }
        }
    }
}
