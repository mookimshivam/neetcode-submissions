class Solution {
    // Floyd's Cycle Detection Just memorize
    // slow-fast pointer 
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // phase-1 the 1st meeting
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        // phase-2 the 2nd meeting
        // dist form 1st meeting to start of cycle = dist form start to start of cycle
        int  slow2 = nums[0];
        while(slow2 != slow){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
