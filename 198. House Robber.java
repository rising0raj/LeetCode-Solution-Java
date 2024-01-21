// Runtime    0ms
// Beats      100.00%


// Memory     41.10MB
// Beats      17.21%

class Solution {
    public int rob(int[] nums) {
        int rob=0,norob=0;
         
        for(int i:nums){
            int newrob=norob+i;
            int newnorob=Math.max(norob,rob);
            rob=newrob;
            norob=newnorob;
        }

        return Math.max(rob,norob);
    }
}
