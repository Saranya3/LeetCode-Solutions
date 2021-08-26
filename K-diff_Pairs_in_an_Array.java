//HashMap
//1
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i) == 1) {
                    result++;
                }
                map.put(i, map.get(i) + 1);
            } else {
                if (map.containsKey(i - k)) {
                    result++;
                }
                if (map.containsKey(i + k)) {
                    result++;
                }
                map.put(i, 1);
            }
        }
        return result;
    }
}
//Binary Search, Sorting
//2
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, 
            n = nums.length;
        
        for (int lo = 0, hi = 1; hi < nums.length; hi++) {
            while(lo < hi && (nums[hi] - nums[lo] > k)) {
                lo++;
            }
            if (lo != hi && nums[hi] - nums[lo] == k) {
                count++;
                
                while(hi != n - 1 && nums[hi] == nums[hi+1]) {
                    hi++;
                }
            }
        }
        return count;
    }
}
