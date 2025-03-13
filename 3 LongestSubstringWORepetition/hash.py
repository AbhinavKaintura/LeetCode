class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        char_dict = {}  # Maps character to its last seen position
        max_length = 0
        start = 0
        
        for i, char in enumerate(s):
            # If character is already in current window, move start pointer
            # to position after the last occurrence
            if char in char_dict and start <= char_dict[char]:
                start = char_dict[char] + 1
            else:
                max_length = max(max_length, i - start + 1)
            
            # Update last position of current character
            char_dict[char] = i
        
        return max_length

            
print(Solution().lengthOfLongestSubstring("abcabcbb")) # 3
print(Solution().lengthOfLongestSubstring("bbbbb")) # 1
print(Solution().lengthOfLongestSubstring("pwwkew")) # 3
