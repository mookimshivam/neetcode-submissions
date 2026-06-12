class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int start = 0;
        int maxLen = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey((int)arr[i])){
                map.put((int)arr[i], 0);
            }
            int count = map.get((int)arr[i]);
            map.put((int)arr[i], count+1);
            int maxCount = findMaxCount(map);
            len = i - start + 1;
            if(len - maxCount <= k){
                maxLen = Math.max(len, maxLen);
                continue;
            }
            map.put((int)arr[start], map.get((int)arr[start]) - 1);
            start += 1;
        }
        return maxLen;
    }
    int findMaxCount(HashMap<Integer,Integer> map){
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
    }
}
