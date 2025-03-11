# Problem: 567. Permutation in String
# Difficulty: Medium

class Solution:
    def checkInclusion(self, s1:str, s2:str) -> str:
        # If s1 is longer than s2, s1's permutation can't be in s2
        if len(s1) > len(s2):
            return False
        
        # Create character frequency counters
        s1_count = [0] * 26
        s2_count = [0] * 26
        
        # Fill the counter for s1
        for ch in s1:
            s1_count[ord(ch) - ord('a')] += 1
        
        # Use sliding window approach
        for i in range(len(s2)):
            # Add current character to window
            s2_count[ord(s2[i]) - ord('a')] += 1
            
            # Remove character that's no longer in the window
            if i >= len(s1):
                s2_count[ord(s2[i - len(s1)]) - ord('a')] -= 1
            
            # Check if current window contains a permutation of s1
            if i >= len(s1) - 1 and s1_count == s2_count:
                return True
        
        return False

       
print(Solution().checkInclusion("ab", "eidbaooo")) # True
print(Solution().checkInclusion("ab", "eidboaoo")) # False