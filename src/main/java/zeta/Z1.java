package zeta;// package whatever; // don't place package name!

class Z1 {

    // Given two sorted arrays A and B. Find the minimum possible value of |a-b| where a belongs to A and b belongs to B.|x| denotes the absolute value of x.


    static  int []A  = { 1,2,3,4,5};
    static  int []B  = {-10,12,50,100};


    public static int smallestDiff( int[] A, int[] B) {

        int a = 0,b = 0, difference = Integer.MAX_VALUE;
        while( true) {

            if( a >= A.length -1 && b >= B.length -1 )
                break;

            int diff1 = Math.abs( A[a] - B[b]);


            if( diff1 < difference){
                difference  = diff1;
            }

            if( A[a] < B[b] ){
                a++;
                if( a == A.length) {
                    a = A.length -1;
                    b++;
                }
            }
            else if ( A[a] == B[b] ) {
                return 0;
            }
            else if( A[a] > B[b] ) {
                b++;
                if( b == B.length) {
                    b = B.length -1;
                    a++;
                }
            }


        }
        return difference;
    }
    public static void main (String[] args) {
        //System.out.println("Hello Java");
        int i = Z1.smallestDiff(A,B);
        System.out.println(i);
    }
}
