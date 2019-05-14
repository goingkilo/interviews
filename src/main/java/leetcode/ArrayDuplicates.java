package leetcode;

public class ArrayDuplicates {

    public int removeDuplicates(int[] nums) {
        int pos = 0;

        for(int i = 1 ; i < nums.length ; i++){

            if( nums[pos] == nums[i]) {
                continue;
            }
            else{
                pos++;
                nums[pos] = nums[i];
            }
        }
        /*
           if next number same as current number, keep going until you find a different number
           copy that value to curIndex+1 ,continue loop
        */
        return pos+1;

    }

    public static void main(String[] args){

        int[] a = {0,0,1,1,1,2,2,3,3,4};

        int i = new ArrayDuplicates().removeDuplicates(a);

        System.out.println(i);
        for(int x  = 0 ; x < i ; x++) {
            System.out.print(a[x] + " ");
        }
        System.out.println();
    }
}
