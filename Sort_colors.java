//1
//Map based Solution
class Solution {
    public void sortColors(int[] nums) {
        int[] count=new int[3];
        int[] tmp=new int[nums.length];
        Arrays.fill(count,0);
        for(int i=0;i<nums.length;i++){
           count[nums[i]]++; 
        }
        for(int i=1;i<3;i++){
            count[i]+=count[i-1];
        }
        for(int i=0;i<nums.length;i++){
            tmp[count[nums[i]]-1]=nums[i];
            count[nums[i]]--;
        }
        for(int i=0;i<nums.length;i++)
            nums[i]=tmp[i];
    }
}

//2
//O(N),O(1)
class Solution {
    public void sortColors(int[] nums) {
        int l=0, r=nums.length-1,mid=0,tmp=0;
        
        while(mid<=r){
            if(nums[mid]==0){
                tmp=nums[l];
                nums[l]=nums[mid];
                nums[mid]=tmp;
                mid++;
                l++;
            }
            else if(nums[mid]==1)
                mid++;
            else{
                tmp=nums[r];
                nums[r]=nums[mid];
                nums[mid]=tmp;
                r--;
            }
        }
    }
}
