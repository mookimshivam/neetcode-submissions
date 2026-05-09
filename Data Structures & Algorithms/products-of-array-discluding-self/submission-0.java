class Solution {
    // 2-pass approach
    // pass_1: accumulating left product
    // pass_2: final product of right accumualted with left
    public int[] productExceptSelf(int[] nums) {
        // result array as in-place doesn't seem to possbile
        int[] result = new int[nums.length];

        // track left accumualted product
        int left = 1;
        // track right accumulated product
        int right  = 1;

        result[0] = left;
        // left product accumulation
        for(int i = 0; i < nums.length - 1; i++){
            left *= nums[i];
            result[i+1] = left;
        }
        // final product of right accumualted with left
        for(int i = nums.length - 1; i > 0; i--){
            right *= nums[i];
            result[i-1] *= right;
        }

        return result;
    }
}  
