class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int l=0;
        int r=height.length -1;
        int sl=0;
        while(l<r){
            sl=Math.min(height[l],height[r]);
            ans=Math.max(ans,sl*(r-l));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}
