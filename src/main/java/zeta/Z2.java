//package zeta;
//
//public class Z2 {
//
//    // package whatever; // don't place package name!
//
//    import java.io.*;
//
//    class MyCode {
//
//        // Given two sorted arrays A and B. Find the minimum possible value of |a-b| where a belongs to A and b belongs to B.|x| denotes the absolute value of x.
//
//// You are given an array A with 0,1. You perform several operations of the following type
//// Given a start cell S >= 0
//// Given an end cell E > S && E < N
//// Flip the bits within E,S.
//// After all the operations are done, print the array.
//
//
//        static  int []A  = { 0,1,1,0,0,1,0,1,0};
////ops = [(1,4), (5,6)]
//
//        class Pair {
//            private int start,end;
//            public Pair(int a, int b){
//                this.start = a;
//                this.end =b;
//            }
//            public int getStart(){
//                return start;
//
//            }
//            public int getEnd(){
//                return end;
//            }
//
//        }
//
//        public static int flipBits( int[] A, List<Pair> operations) {
//            for( Pair operation : operations) {
//
//                int start = operation.getStart();
//                int end = operation.getEnd();
//
//                if( start > A.length || end > A.length ) throw new RuntimeException("start/end gt N");
//
//                for( int i = start ; i <= end ; i++ ) {
//                    A[i] = (A[i] == 0 ? 1 : 0);
//                }
//                System.out.println(A);
//
//            }
//            return A;
//
//        }
//
//        public static void main (String[] args) {
//
//            List<Pair> operations = new ArrayList<>();
//            operations.add( new Pair(1,4));
//            //operations.add( new Pair(5,6));
//            int[] i = MyCode.flipBits(A, operations);
//            System.out.println(i);
//        }
//    }
//
//}
