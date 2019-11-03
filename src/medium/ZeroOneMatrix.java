package medium;

/*
    Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

    The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {

    public static void main(String... args) {

        int[][] matrix = {{0,0,1,0,1,1,1,0,1,1},{1,1,1,1,0,1,1,1,1,1},
                {1,1,1,1,1,0,0,0,1,1},{1,0,1,0,1,1,1,0,1,1},{0,0,1,1,1,0,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,0,1,0,1},{0,1,0,0,0,1,0,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},{1,0,1,1,1,0,1,1,1,0}};
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        System.out.println(zeroOneMatrix.updateMatrix(matrix));
    }

    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] != 0) {
                    f[i][j] = m+n;
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

                if (i != 0) f[i][j] = Math.min(f[i][j], 1 + f[i-1][j]);
                if (j != 0) f[i][j] = Math.min(f[i][j], 1 + f[i][j-1]);
            }

        for (int i = m-1; i >= 0; i--)
            for (int j = n-1; j >= 0; j--) {

                if (i != m-1) f[i][j] = Math.min(f[i][j], 1 + f[i+1][j]);
                if (j != n-1) f[i][j] = Math.min(f[i][j], 1 + f[i][j+1]);
            }

        return f;
    }

}
