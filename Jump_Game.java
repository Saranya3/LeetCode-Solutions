//1
//DP
class Solution {
    public boolean canJump(int[] nums) {
        int[] jmp=new int[nums.length];
        jmp[0]=0;
        if(nums[0]==0 && nums.length==0)
            return false;
        for(int i=1;i<nums.length;i++){
            jmp[i]=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if((i<=j+nums[j]) && jmp[j]!=Integer.MAX_VALUE)
                    jmp[i]=Math.min(jmp[i],jmp[j]+1);
            }
        }
        return (jmp[jmp.length-1]!=Integer.MAX_VALUE);
    }
}
//2
//Greedy
class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        
        for(int i=0;i<nums.length;i++){
            if(i>max)
                return false;
            max=Math.max(max,nums[i]+i);
        }
        return true;
    }
}
