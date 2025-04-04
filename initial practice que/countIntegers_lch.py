class Solution:
    def count(self, num1: str, num2: str, min_sum: int, max_sum: int) -> int:
        count = 0
        values = []
        for num in range(int(num1), int(num2)+2):
            n = self.digits_sum(num)
            if min_sum<=n and max_sum>=n:
                count +=1
                values.append(n)
        print(values)
        return count
    
    def digits_sum(self, num):
        sum = 0
        if num < 10:
            return num
            
        while(num > 10):
            a = num%10
            sum += a
            num /=10
        return sum
    
print(Solution().count(num1 = "4179", num2 = "4748", min_sum = 8, max_sum = 14))
