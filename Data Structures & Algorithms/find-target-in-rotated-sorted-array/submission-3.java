class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == target)
                return mid;
            // entire rotated portion before mid
            else if(nums[mid] >= nums[l]){
                // left will be continous incr order elements
                if(nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else 
                    l = mid + 1;
            }
            // part of rotated portion before mid
            else{
                // right will be continous incr elements
                if(nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else 
                    r = mid - 1;
            }
        }
        return -1;
    }
}
