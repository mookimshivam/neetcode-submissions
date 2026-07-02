class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int index = 0;

        if(len % 2 == 0)
            index = len/2 - 1;
        if(len % 2 == 1)
            index = len/2;

        int k = 0;
        int i = 0, j = 0;
        float num = 0;
        while(k <= index && i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                num = nums1[i];
                i++;
            }
            else {
                num = nums2[j];
                j++;
            }
            k++;
        }
        while(k <= index && i < nums1.length){
            num = nums1[i];
            i++;
            k++;
        }
        while(k <= index && j < nums2.length){
            num = nums2[j];
            j++;
            k++;
        }
        if(len % 2 == 0){
            if(i < nums1.length && j < nums2.length)
                num += Math.min(nums1[i], nums2[j]);
            else if(i < nums1.length)
                num += nums1[i];
            else 
                num += nums2[j];
            num /= 2;
        }
        return num;
    }
}
