class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 0 or n == 1:
            return 1
        
        ans = (n+1) * [0]
        ans[0] = ans[1] = 1
        for i in range(2, n+1):
            ans[i] = ans[i-1] + ans[i-2]

        return ans[n]
    
print(Solution().climbStairs(5))  # Output: 8
print(Solution().climbStairs(6))  # Output: 13