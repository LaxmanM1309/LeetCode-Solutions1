class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double [] sum=new double [nums1.length+nums2.length];
        int a=0;
        for (int i=0;i<nums1.length;i++){
            sum[a++]=nums1[i];
        }
        for (int j=0;j<nums2.length;j++){
            sum[a++]=nums2[j];
        }
        Arrays.sort(sum);
        int n = sum.length;
        if (n%2==1){
            return sum[n/2];
        }
        else {
            return (sum[n/2-1]+sum[n/2])/2;
        }
    }
}