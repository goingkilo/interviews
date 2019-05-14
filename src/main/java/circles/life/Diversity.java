package circles.life;

public class Diversity {

    static int numWays( int m, int w) {
        // 2m 1w
        int m2w1 = 0;

        for( int i = 0 ; i < m ; i++ ) {
            for( int j = 0; j < m  ; j++){
                if( j == i )
                    continue;
                for( int k = 0 ;  k < w ; k++) {
                    m2w1 ++;
                }


            }
        }

        // 1m 2w
        int m1w2 = 0;
        for( int i = 0 ; i < w ; i++ ) {
            for( int j = 0; j < w  ; j++){
                if( j == i ) {
                    continue;
                }
                for( int k = 0 ;  k < m ; k++) {
                    m1w2 ++;
                }


            }
        }

        return (m2w1 + m1w2)/2;
    }

    public static void main(String[] args) {
        System.out.println(numWays(3, 0));
        System.out.println(numWays(2, 2));
    }
}
