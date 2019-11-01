package easy;

/*
    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

    Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

    To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.

    Replace the color of all of the aforementioned pixels with the newColor.

    At the end, return the modified image.
 */
public class FloodFill {

    private boolean[][] t;
    private static final int[] x = {-1, 1, 0, 0};
    private static final int[] y = {0, 0, -1, 1};

    public static void main(String... args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill floodFill = new FloodFill();
        System.out.println(floodFill.floodFill(image, 1, 1, 2));
    }

    private void dfs(int[][] image, int sr, int sc, int m, int n, int p, int newColor) {

        for (int i = 0; i < 4; i++) {

            int u = sr + x[i];
            int v = sc + y[i];
            if (u < 0 || u >= m || v < 0 || v >= n) continue;

            if (!t[u][v] && image[u][v] == p) {

                t[u][v] = true;
                image[u][v] = newColor;
                dfs(image, u, v, m, n, p, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int m = image.length;
        int n = image[0].length;
        t = new boolean[m][n];
        t[sr][sc] = true;
        dfs(image, sr, sc, m, n, image[sr][sc], newColor);
        image[sr][sc] = newColor;
        return image;
    }

}
