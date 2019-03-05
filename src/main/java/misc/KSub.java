package misc;

import java.io.IOException;

public class KSub {
    /*
 * Complete the function below.
 */

    static long kSub(int k, int[] nums) {
        int i=0,j=0;
    	int mod = 0;

    	for(i=0;i<nums.length;i++){
    		int sum = 0;
    		for(j=i;j<nums.length;j++) {


    			if(i==j) {
    				sum = nums[i];
    				if(nums[i]%k == 0) {
    					mod++;
    				}
    			} else {
    				sum = sum+nums[j];
    				if(sum%k == 0){

    					mod++;

    				}
    			}
    		}
    	}

    	System.out.println("mod"+mod);

    	return mod;

    }


    int kSub( int[] x ) {
    	return 0;
    }

    public static void main(String[] args) throws IOException{
//        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        long res;
//        int _k;
//        _k = Integer.parseInt(in.nextLine());
//
//
//        int _nums_size = Integer.parseInt(in.nextLine());
//        int[] _nums = new int[_nums_size];
//        int _nums_item;
//        for(int _nums_i = 0; _nums_i < _nums_size; _nums_i++) {
//            _nums_item = Integer.parseInt(in.nextLine());
//            _nums[_nums_i] = _nums_item;
//        }
//
        long res = kSub( 3, new int[]{1,2,3,4,1} );
        System.out.println( res );

//        bw.write(String.valueOf(res));
//        bw.newLine();
//
//        bw.close();
    }
}
