// Runtime   1ms
// Beats     100.00%


// Memory    41.39MB
// Beats     93.04%


class Solution {
    public int maxLength(List<String> arr) {
       List<Integer> arr2 = new ArrayList<>();
        for(String word: arr) {
            int bitSet = str2BitInt4(word);
            if (bitSet > 0) arr2.add(str2BitInt4(word));
        }
        int[] data = new int[arr2.size()];
        for (int i = 0; i < data.length; i++)
            data[i] = arr2.get(i);

        return helper_dfs(data, 0, 0);
    }
    private int helper_dfs(int[] data, int begin, int bitSet) {
        int maxLen = Integer.bitCount(bitSet);
        for (int i = begin; i < data.length; i++) {
            if ((data[i] | bitSet) == (data[i] ^ bitSet))
                maxLen = Math.max(maxLen, helper_dfs(data, i + 1, bitSet | data[i]));
        }
        return maxLen;
    }

    private int str2BitInt4(String word){
        int x = 0;
        for(char c : word.toCharArray()) {
            if ((x >> (c - 'a') & 1) == 1) return -1;
            x |= 1 << c - 'a';
        }
        return x;  
    }
}
