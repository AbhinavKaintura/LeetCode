from typing import List


class Solution:
    def maxProfit(self, prices:List[int]) -> int:
        
        min_price, max_profit = float('inf'), 0

        for price in prices:
            
            if min_price > price:
                min_price = price
            profit = price - min_price

            if profit > max_profit:
                max_profit = profit

        return max_profit

print(Solution().maxProfit([7,1,5,3,6,4])) # solution: 5
print(Solution().maxProfit([7,6,4,3,1])) # solution: 0