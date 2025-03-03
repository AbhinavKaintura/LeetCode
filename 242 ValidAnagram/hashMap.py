class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        
        char_map = {}

        for ch in s:
            char_map[ch] = char_map.get(ch, 0) + 1

        for ch in t:
            if ch not in char_map or char_map[ch] == 0:
                return False
            char_map[ch] -=1

        return True
    
print(Solution().isAnagram("anagram", "nagaram")) # solution: True
print(Solution().isAnagram("rat", "car")) # solution: False