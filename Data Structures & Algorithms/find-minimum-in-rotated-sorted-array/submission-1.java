class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int l = 0, r = nums.length - 1;
        while(l <= r){
            // check if list already in order
            // just return the left most element
            if(nums[l] <  nums[r])
                return Math.min(min, nums[l]);
            int mid = (l+r)/2;
            min = Math.min(min, nums[mid]);
            if(nums[mid] >= nums[l])
                l = mid + 1;
            else 
                r = mid -1;
        }
        return min;
    }
}
