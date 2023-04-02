package DSA-.DynamicProgramming.Day1;

public class L3FrogJump {
    
    int minCost(int idx){
        if(idx == 0) return 0;

        int l1 = minCost(idx-1) + Math.abs(heights[i] + heights[i - 1]);

        int l2 = Integer.MAX_VALUE;
        if(idx > 1)
            l2 = minCost(idx-2) + Math.abs(heights[i] + heights[i - 2]);

        return Math.min(l1, l2);
    }

    // TC: o(n) sc: o(n)

    //memoization
    int []dp = new int[n+1];
    Arrays.fill(dp, -1);

    int minCost(int idx, int []dp){
        if(idx == 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int l1 = minCost(idx-1, dp) + Math.abs(heights[i] + heights[i - 1]);

        int l2 = Integer.MAX_VALUE;
        if(idx > 1)
            l2 = minCost(idx-2, dp) + Math.abs(heights[i] + heights[i - 2]);

        return dp[idx] = Math.min(l1, l2);
    }
}
