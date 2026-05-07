class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int num: nums){
            int current = 1;
            set.add(num);
            while(set.contains(num - 1))
                num--;
            while(set.contains(num + 1)){
                num++;
                current++;
            }
            if(current > max)
                max = current;
        }
        return max;
    }
}
