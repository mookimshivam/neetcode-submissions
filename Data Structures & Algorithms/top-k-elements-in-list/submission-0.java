class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer,Integer>> count = new LinkedList<Map.Entry<Integer,Integer>>(frequency.entrySet());
        Collections.sort(count, (a,b) -> b.getValue().compareTo(a.getValue()));

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = count.get(i).getKey();
        }

        return result;
    }
}
