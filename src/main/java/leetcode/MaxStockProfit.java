package leetcode;

public class MaxStockProfit {

    public static void main(String[] args) {

        int[] a = {1,7,4,2};//7, 6, 4, 3, 1};//1,2,3,4,5};//7,1,5,3,6,4};

        MaxStockProfit m = new MaxStockProfit();


//        System.out.println(m.singleTransactionMax(a));
        System.out.println("ans."+m.calculateMaxProfit(a));
    }



    private int singleTransactionMax(int[] a){

        int low = a[0], hi = a[0],max = 0;
        for(int i = 0 ; i< a.length ; i++){
            if( a[i]< low){
                low =a[i];
                hi = a[i];
            }
            if( a[i] > hi){
                hi = a[i];
                if( max < (hi - low)){
                    max = hi - low;
                }
            }
        }
        return max;
    }


    private int calculateMaxProfit(int[] a) {
        int low = a[0], hi = a[0], i = 0,profit = 0;


        while( i < a.length-1) {

            System.out.println(i);

            while( i < a.length-2 && a[i] > a[i+1]  ){
                i++;
            }
            low = a[i];
            i++;
            while( i < a.length-1 && a[i] < a[i+1] ){
                i++;
            }
            hi = a[i];

            if( hi > low)
                profit += (hi - low);
            i++;

        }
        //if( profit < 0) profit = 0;
        return profit;
    }
}
