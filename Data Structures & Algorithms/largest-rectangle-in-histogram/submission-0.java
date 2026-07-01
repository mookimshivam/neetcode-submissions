class Solution {
    public int largestRectangleArea(int[] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int length = heights.length;
        int i = 0;
        int j = 0;
        list.add(Arrays.asList(i, heights[i++]));
        int maxArea = 0;

        while(i < length){
            if(heights[i] >= list.get(j).get(1)){
                list.add(Arrays.asList(i, heights[i++]));
                j++;
            }
            else{
                int left = 0;
                while(j >= 0){
                    List<Integer> before = list.get(j);
                    if(before.get(1) > heights[i]){
                        left = before.get(0);
                        list.remove(j--);
                        maxArea = Math.max(maxArea, before.get(1)*(i - before.get(0)));
                    }
                    else
                        break;
                }
                list.add(Arrays.asList(left, heights[i++]));
                j++;
            }
        }
        while(j >= 0){
            List<Integer> before = list.get(j);
            list.remove(j--);
            maxArea = Math.max(maxArea, before.get(1)*(i-before.get(0)));
        }
        return maxArea;
    }
}
