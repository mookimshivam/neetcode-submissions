class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int len = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey((int)arr[i])){
                int index = map.get((int)arr[i]);
                // to check if this repeat is from current sub-string or not
                if(index >= start){
                    // when repeated new sub-string will start from next position
                    start = index + 1;
                    // update length to consider from new start
                    len = i - start;
                }
            }
            len++;
            // put char ASCII as key and its index as value
            map.put((int)arr[i], i);
            // always keeping the max len track
            // as will get many sub-string later but need max-len one
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
