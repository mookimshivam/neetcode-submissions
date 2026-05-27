class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int minSpeed = 1, maxSpeed = 0;
        int fallBack = 0;
        // getting upper-limit for speed
        for(int i = 0; i < len; i++){
            if(piles[i] > maxSpeed)
                maxSpeed = piles[i];
        }
        // 1-unit of time for each pile so maxSpeed is the way
        if( len == h)
            return maxSpeed;

        while(minSpeed <= maxSpeed){
            int mid = (maxSpeed + minSpeed)/2;
            int timeNeeded = 0;
            for(int pile: piles){
                timeNeeded += Math.ceil((double)pile/mid);
            }

            if(timeNeeded <= h){
                fallBack = mid;
                maxSpeed = mid - 1;
            }
            else
                minSpeed = mid + 1;
        }
        return fallBack;
    }
}
