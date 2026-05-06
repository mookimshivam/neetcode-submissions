class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // iterating over list of string
        for(String str: strs){
            int[] tracker = new int[26];
            
            // iterating over string 
            for(int i = 0; i < str.length(); i++){
                // tracking its char spread
                tracker[str.charAt(i) - 97]++;
            }

            // coverting the char spread to key
            String key = Arrays.toString(tracker);

            // using the key as key for that anagram list
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(str);
            map.put(key, values);
        }

        return map.values().stream().toList();
    }
}
