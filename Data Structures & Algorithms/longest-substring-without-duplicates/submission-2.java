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
                if(index >= start){
                    len = i - index - 1;
                    start = index + 1;
                }
            }
            len++;
            map.put((int)arr[i], i);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
