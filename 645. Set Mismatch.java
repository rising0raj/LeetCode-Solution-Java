// Runtime     3ms
// Beats       81.72%

// Memory      45.46MB
// Beats       42.36%



class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] exist = new boolean[nums.length];
        int d = 0, l = 0;

        Arrays.fill(exist, true);

        for(int i:nums){
            if(exist[i-1] == false){
                d=i;
            }
            exist[i-1]=false;
        }

        for(int i = 0; i < nums.length; i++) {
            if(exist[i]) {
                l= i+1;
                break;
            }
        }

        return new int[]{d,l};
    }
}
