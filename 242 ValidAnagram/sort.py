#An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.


class Solution:
    def isAnagram(self, s:str, t:str) -> bool:

        if len(s) != len (s) or len(s) == 0:
            return False
        
        return sorted(t) == sorted(s)

print(Solution().isAnagram("anagram", "nagaram")) # solution: True
print(Solution().isAnagram("rat", "car")) # solution: False