class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        if(len < 2)
            return 0;
        int  i = 0, j = len-1, areaMax = 0;
        while(i < j){
            // maintaing max area across
            int area = Math.min(heights[i], heights[j]) * (j - i);
            areaMax = Math.max(areaMax, area);

            // larger bar are nothing but surplus causing no harm
            // small bars are becoming the bottle-neck
            // best to move when at small bar
            if(heights[i] < heights[j])
                i++;
            else
                j--;
        }
        return areaMax;
    }
}
