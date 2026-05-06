class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String now = new String(c);
            List<String> values = map.getOrDefault(now, new ArrayList<>());
            values.add(s);
            map.put(now, values);
        }
        return map.values().stream().toList();
    }
}
