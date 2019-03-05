package misc;

public class GridPath {

    int [][] grid ;
    int max;

    public GridPath() {
        java.util.Random r = new java.util.Random( System.currentTimeMillis());

        grid = new int[10][10];
        for( int i = 0 ; i < grid.length ; i++) {
            for( int j = 0 ; j < grid.length ; j++) {
                grid[i][j] = r.nextInt( 15);
            }
        }
    }

    public void go( int x, int y, int sum){
        if( x >= grid.length || y >= grid.length ) {
            //out of the grid
            return;
        }

        if( x == grid.length -1 && y == grid.length -1){
            sum += grid[x][y];
            if( sum > max) max = sum;
        }

        // go left
        go( x +1, y, sum + grid[x][y]);

        // go down
        go( x, y+1, sum+ grid[x][y]);
    }

    void disp(){
        for( int i = 0 ; i < grid.length ; i++) {
            for( int j = 0 ; j < grid.length ; j++) {
                System.out.print( grid[i][j]);
                System.out.print( " ");
            }
            System.out.print( "\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("x");
        GridPath g = new GridPath();
        g.disp();
        g.go(0,0,0);
        System.out.println( g.max);
    }

}
