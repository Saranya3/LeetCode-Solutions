class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp=new ArrayList<>();
        
        int i=0,j=0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                tmp.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res=new int[tmp.size()];
        for(int k=0;k<tmp.size();k++){
            res[k]=tmp.get(k);
        }
        return res;
    }
}
