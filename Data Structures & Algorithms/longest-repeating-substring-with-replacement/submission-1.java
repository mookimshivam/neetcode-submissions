class Solution {
    public int characterReplacement(String s, int k) {
        // map will always have active winow keys and their frequency 
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int start = 0;
        int maxLen = 0;
        int len = 0;
        // 1-pass over the entire string
        for(int i = 0; i < s.length(); i++){
            // for tracking the count
            // if map doesnt have make a entry for it
            if(!map.containsKey((int)arr[i])){
                map.put((int)arr[i], 0);
            }
            int count = map.get((int)arr[i]);
            map.put((int)arr[i], count+1);
            // find the max frequency 
            // will give count of most frequently occured element in the window
            int maxCount = findMaxCount(map);
            len = i - start + 1;

            // validating the active window
            // by checking if we have necessary amount of replacements
            if(len - maxCount <= k){
                // post validating window update the max-length
                maxLen = Math.max(len, maxLen);
                continue;
            }
            // making the count accurate as we shift the window
            map.put((int)arr[start], map.get((int)arr[start]) - 1);
            // shifting the window 
            start += 1;
        }
        return maxLen;
    }
    // find the key with max value and return same
    int findMaxCount(HashMap<Integer,Integer> map){
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
    }
}
