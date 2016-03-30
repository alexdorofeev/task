/**
 * Created by Dorofeev on 3/30/2016.
 */
public class ImageTurn {
    public static void main(String[] args) {
        int[][] matrix= {{55, 11, 11, 11}, {55, 44, 44, 22}, {55, 44, 44, 22}, {33, 33, 33, 22}};
        showImage(matrix);
        turnImage(matrix,4);
        System.out.println();
        showImage(matrix);
    }

    public static void turnImage(int[][] matrix, int n){
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;

            }
        }

    }

    public static void showImage(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
