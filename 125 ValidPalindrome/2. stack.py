#solu2 using stack 
#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def isPalindrome(self, s:str) -> bool:

        charStr = ''.join(char.lower() for char in s if char.isalnum())

        if not charStr:
            return True

        stack = []
        mid = len(charStr) // 2

        for i in range(mid):
            stack.append(charStr[i])

        midCh = mid + 1 if len(charStr)%2 != 0 else mid

        for i in range (midCh, len(charStr)):
            if not stack or stack.pop() != charStr[i]:
                return False

        return len(stack)==0

print(Solution().isPalindrome("A man, a plan, a canal: Panama")) 
