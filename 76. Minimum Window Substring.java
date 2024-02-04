// Answer1
// Runtime   1ms
// Beats     100.00%


// Memory    44.53MB
// Beats     62.18%


class Solution {
    public String minWindow(String s, String t) {
        int[] map= new int[123];
        int left=0,right=0, count=t.length(),sub_len= Integer.MAX_VALUE,start=0;

        for(char c: t.toCharArray()) 
            map[c]++;

        char[] ch = s.toCharArray();
        while(right<s.length())
        {
            if(map[ch[right++]]-->0) count--;

            while(count==0)
            {
                if((right-left)<sub_len) sub_len= right-(start=left);
                if(map[ch[left++]]++==0) count++;
            }
        }

        return sub_len==Integer.MAX_VALUE? "": s.substring(start,start+sub_len);
    }
}


// Answer1
// Runtime    54ms
// Beats      27.19%

// Memory     45.58MB
// Beats      16.45%


class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() )  
            return "";
        
        String ans="";
        int []tcount = new int [128];
        for(char c: t.toCharArray()){
            tcount[c]++;
        }

        char []schar = s.toCharArray();
        int left=0, right=0;
        int found=0, tofind=t.length();
        int min=Integer.MAX_VALUE;

        while(right<s.length()){
            char ch=schar[right];
            tcount[ch]--;
            if(tcount[ch] >=0)
                found++;
            while(found == tofind){
                if(min > (right - left +1 ) ){
                    min = right-left+1;
                    ans=s.substring(left,right+1);
                }
                tcount[schar[left]]++;
                if(tcount[schar[left]] >0){
                    found--;
                }
                left++;
            }
            right++;
        }

        return ans;
    }
}
