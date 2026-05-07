class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // initialize set with array
        for(int num: nums) 
            set.add(num);

        int max = 0;
        // iterate over the set 
        for(int num: nums){
            // look for next elements only if its the 1st element 
            if(!set.contains(num - 1)){
                int current = 1;
                //  iterate over the entire sequence
                while(set.contains(num + 1)){
                    num++;
                    current++;
                }
                if(current > max)
                    max = current;
            }
        }
        return max;
    }
}
