class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] track = new int[26];
        for(int i = 0; i < s.length(); i++){
            track[s.charAt(i) - 97]++;
            track[t.charAt(i) - 97]--;
        }
        for(int i: track){
            if( 0 != i)
                return false;
        }
        return true;
    }
}
