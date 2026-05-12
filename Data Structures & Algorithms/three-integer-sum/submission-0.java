class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort first — enables two pointers
    
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate values for the fixed element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
        
            // early exit: smallest possible sum already > 0
            if (nums[i] > 0) break;
        
            int l = i + 1, r = nums.length - 1;
        
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
            
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // skip duplicates on both sides after a find
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++; r--;
                } else if (sum < 0) {
                    l++; // need bigger sum
                } else {
                    r--; // need smaller sum
                }
            }
        }
        return result;
    }
}
