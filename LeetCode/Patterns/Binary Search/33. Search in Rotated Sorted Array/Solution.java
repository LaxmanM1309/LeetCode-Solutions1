class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0 ;
        int r = n - 1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(nums[mid] > nums[n-1])   l = mid+1;
            else r = mid-1;
        }
        return l;
    }
    public int binarySearch(int[] nums,int left,int right,int target){
        while(left <= right){
            int mid = (left+right) / 2;
            if(nums[mid] == target)  return mid;
            else if(nums[mid] < target)  left = mid + 1;
            else    right = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int mi = findMin(nums);
        int ans = binarySearch(nums,0,mi-1,target);
        if(ans != -1)   return ans;
        else    return binarySearch(nums,mi,n-1,target);
    }
}