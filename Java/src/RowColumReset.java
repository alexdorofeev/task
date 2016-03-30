/**
 * Created by Dorofeev on 3/30/2016.
 */

/**
 *  Алгоритм, реализует следующее условие:
 *  если элемент матрицы в точке M × N равен 0,
 *  то весь столбец и вся строка обнуляются
 */
public class RowColumReset {
    public static void main(String[] args) {
        int[][] matrix= {{5, 1, 1, 1}, {5, 4, 4, 2}, {5, 4, 0, 2}, {3, 3, 3, 2}};
            resetColumRowReset(matrix);
        showMatrix(matrix);

    }

    public static void resetColumRowReset(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] colum = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    colum[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] || colum[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
