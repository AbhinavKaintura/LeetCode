class Solution:
    def maxUniqueSplit(self, s: str) -> int :
        seen = set()
        return self.backtrack(s, 0, seen)            


    def backtrack(self, s, start, seen):

        if start == len(s):
            return 0
        
        max_count = 0
        for end in range( start+1, len(s)+1):
            substring = s[start:end]
            if substring not in seen:
                seen.add(substring)
                max_count = max(max_count, 1 + self.backtrack(s, end, seen))
                seen.remove(substring)
        return max_count
    
print(Solution().maxUniqueSplit("ababccc"))

