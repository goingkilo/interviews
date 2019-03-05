package misc;

/**
 * Created by kraghunathan on 4/3/18.
 */
public class MatrixRectangles {
    /*
    11111
    11101
    01111

     */

    public static void main(String[] args) {
        int[][] matrix = { {1,1,1,1,1}, {1,1,1,0,1},{0,1,1,1,1}};


        boolean flag = false;
        int start = -1;
        int end = -1;

        for( int i = 0 ; i < matrix.length ; i ++ ) {
            if( !flag ) {
                if( matrix[0][i] == 1) {
                    flag = true;
                }

            }
        }
    }
}
