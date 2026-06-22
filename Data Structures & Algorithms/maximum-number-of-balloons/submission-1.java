class Solution {
    // Generalized just replace the word by one needed
    public int maxNumberOfBalloons(String text) {
        int[] tracker = new int[26];
        for(char c: text.toCharArray()){
            tracker[c - 'a']++;
        }
        int[] lookFor = new int[26];
        // replace balloon with any word and it will work
        for(char c: "balloon".toCharArray()){
            lookFor[c - 'a']++;
        }
        int instances = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(0 != lookFor[i])
                instances = Math.min(tracker[i]/lookFor[i], instances);
        }
        return instances;
    }
}