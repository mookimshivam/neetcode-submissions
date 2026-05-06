class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            boolean counterThere = map.containsKey(target - nums[i]);
            if(counterThere){
                int counterIndex = map.get(target - nums[i]);
                if(counterIndex != i){
                    result = new int[]{i, counterIndex};
                    Arrays.sort(result);
                    break;
                }
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
