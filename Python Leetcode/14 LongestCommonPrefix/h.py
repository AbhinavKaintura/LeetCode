from typing import List
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:

        ans = strs[0]

        for word in strs[1:]:
            while ans != word[:len(ans)]:
                ans = ans[:-1]

                if not ans:
                    return ""
                
        return ans
    
print(Solution().longestCommonPrefix(["flower","flow","flight"])) # solution: "fl"
print(Solution().longestCommonPrefix(["dog","racecar","car"])) # solution: ""