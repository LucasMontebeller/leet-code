class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int necessaryIterations = ((nums1.length + nums2.length) / 2) + 1;
        int[] sortedMergedArray = new int[necessaryIterations];
        
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < necessaryIterations) {

            if (i >= nums1.length) {
                sortedMergedArray[k++] = nums2[j++];
            }
            else if (j >= nums2.length) {
                sortedMergedArray[k++] = nums1[i++];
            }
            else if (nums1[i] <= nums2[j]) {
                sortedMergedArray[k++] = nums1[i++];
            }
            else {
                sortedMergedArray[k++] = nums2[j++];
            }
        }
        
        return (nums1.length + nums2.length) % 2 == 0 ?
            (sortedMergedArray[necessaryIterations - 1] + sortedMergedArray[necessaryIterations - 2]) / 2.0 :
            (sortedMergedArray[necessaryIterations - 1]);
    }
}