class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i:i+len(needle)] == needle:
                return i
            
        return -1
    

print(Solution().strStr("sadbutsad", "but")) # 3
print(Solution().strStr("hello", "ll")) # 2
