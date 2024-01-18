// Runtime    0ms
// Beats      100.00%

// Memory     40.35MB
// Beats      23.54%


class Solution {
    private int[] memo = new int[46];

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2 || n == 3) return n;

        if (memo[n] != 0) {
            return memo[n];
        }

        int ways = climbStairs(n - 1) + climbStairs(n - 2);
        memo[n] = ways;

        return ways;
    }
}
