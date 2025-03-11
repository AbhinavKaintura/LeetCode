from itertools import permutations


class Solution:
    def checkInclusion(self, s1:str, s2:str) -> str:
        if len(s1) > len(s2):
            return False
        
        permList = self.get_permutation(s1)
        for perm in permList:
            if perm in s2:
                return True
        return False

    def get_permutation(self, s:str) -> str:
        if len(s) == 1:
            return s
        else:
            s = [''.join(p) for p in permutations(s) ]
            return s
        
print(Solution().checkInclusion("ab", "eidbaooo")) # True
print(Solution().checkInclusion("ab", "eidboaoo")) # False