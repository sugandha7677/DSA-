package DSA-.DynamicProgramming.Day1;

// count ways to reach nth stair from 0th  --> can take 1 & 2 steps

public class L2ClimbingStairs {
    
    // 1. recursion

    int climb(int n){

        if(n == 0) return 1;
        if(n < 0 ) return 0;

        return climb(n-1) + climb(n-2);
    }

    //TC: O(n) // sc: o(n)

    //2. Memoization 
    
    int []dp = new int [n+1];
    Arrays.fill(dp, -1);

    int climb(int n, int []dp){
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = climb(n-1, dp) + climp(n-2, dp);
    }

    // TC: O(N)
    // SC: O(N)-- RECURSION + O(N) --DP ARRAY

    //3. tabulation

    int []dp = new int [n+1];
    dp[0] = 0;
    dp[1] = 1;

    for(int i = 2; i <= n; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }

    System.out.println(dp[n]);

    // TC: O(N)
    // SC: O(N)

    //4. space optimisation

    int prev2 = 0;
    int prev = 1;

    for(int i = 2; i <= n; i++){
        int curri = prev + prev2;

        prev2 = prev;
        prev = curri;
    }

    System.out.println(prev);

    // TC: O(N)
    // SC: O(1)
}
