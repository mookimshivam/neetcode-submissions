class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // build frequency map
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // convert set-> arrayList to sort 
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // sort entries by value (frequency) descending
        list.sort((a, b) -> b.getValue() - a.getValue());

        // take top k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}
