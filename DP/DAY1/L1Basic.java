//program to find fibonacci sequence

public class L1Basic {
    
    //1. recursion

    int fib(int n){
        if(n <= 1) return 1;

        return fib(n-1) + fib(n-2);
    }

    // TC: O(n) 
    // SC: O(n)

    // have overlapping subproblem

    //2. Memoization ---> use dp[]
    
    int []dp = new int [n+1];
    Arrays.fill(dp, -1);

    int fib(int n, int []dp){
        if(n <= 1) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
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
