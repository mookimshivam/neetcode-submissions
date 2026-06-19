class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        
        // tracking s1 
        int[] s1Tracker = new int[26];
        // tracking the s1-length window in s2
        int[] windowTracker = new int[26];

        // build s1 tracker
        for(int i = 0; i < s1.length(); i++){
            s1Tracker[s1.charAt(i) - 'a']++;
        }

        // build initial window tracker
        int len = s1.length();
        for(int i = 0; i < len; i++){
            windowTracker[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1Tracker, windowTracker))
            return true;

        // move window 1 char ahead 
        for(int i = 0, j = len; j < s2.length(); i++, j++){
            // clear the initial left
            windowTracker[s2.charAt(i) - 'a']--;
            // add the new right
            windowTracker[s2.charAt(j) - 'a']++;

            // comparind the trackers 
            if(Arrays.equals(s1Tracker, windowTracker))
                return true;
        }

        return false;
    }
}
