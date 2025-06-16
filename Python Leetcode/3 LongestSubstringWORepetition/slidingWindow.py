class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        max_length, n, left, seen = 0, len(s), 0, set()

        for right in range(n):

            while s[right] in seen:
                seen.remove(s[left])    # we are removing the left element from the seen set such that all the 
                left +=1                # elements are removed till the current element so that the seen set is empty
            
            seen.add(s[right])
            max_length = max(max_length, right-left+1)

        return max_length
            
print(Solution().lengthOfLongestSubstring("abcabcbb")) # 3
print(Solution().lengthOfLongestSubstring("bbbbb")) # 1
print(Solution().lengthOfLongestSubstring("pwwkew")) # 3
