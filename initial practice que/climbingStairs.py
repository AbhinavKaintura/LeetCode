# You are climbing a staircase. It takes n steps to reach the top.
# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class ClimbingStaris:
    def climbStairs(self, n: int) -> int :

        if n == 0 or n == 1:
            return 1
        
        num = [0] * (n+1)
        num[0] = num[1] = 1
        for i in range(2, n+1):
            num[i] = num[i-1] + num[i-2]

        print(num)
        return num[n]

user_input = input("n ==> ")
print(ClimbingStaris().climbStairs(int(user_input)))