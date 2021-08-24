class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        //Point of rotation
        while(left <right){
            // modified binary search
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int start = left;
        //System.out.println(start);
        left = 0;
        right = nums.length -1;
        //We have 2 sorted lists now
        //Checking in which part the target lies
        if(target >= nums[start] && target <= nums[right]){
            left = start;
        }else{
            right = start;
        }
        //Binary Search
        while(left <= right){
            int mid = left + (right -left)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left  = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
