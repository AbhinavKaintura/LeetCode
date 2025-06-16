class Solution:
    def lengthOfLongestSubstring(self, s:str) -> str:

        max_length = 0
        n = len(s)

        for i in range(n):
            for j in range(i, n):
                if len(set(s[i:j+1])) == j-i+1: # if any element repeats the condition not holds true as in set there's no repetition 
                    max_length = max(max_length, j-i+1)

        return max_length
    
print(Solution().lengthOfLongestSubstring("abcabcbb")) # 3
print(Solution().lengthOfLongestSubstring("bbbbb")) # 1
print(Solution().lengthOfLongestSubstring("pwwkew")) # 3
