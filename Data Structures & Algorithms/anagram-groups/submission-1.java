class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 97]++;
            }
            List<String> values = map.getOrDefault(Arrays.toString(count), new ArrayList<>());
            values.add(s);
            map.put(Arrays.toString(count), values);
        }
        return map.values().stream().toList();
    }
}
