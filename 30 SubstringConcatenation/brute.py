
from itertools import permutations
from typing import List

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        result = []
        word_len = len(words[0])
        total_words = word_len * len(words)

        words_prem = [''.join(perm) for perm in permutations(words)]

        for i in range(len(s) - total_words + 1):
            substring = s[i:i+total_words]

            if substring in words_prem:
                result.append(i)

        return result
    

print(Solution().findSubstring("barfoothefoobarman", ["foo","bar"])) # [0,9]
print(Solution().findSubstring("wordgoodgoodgoodbestword", ["word","good","best","word"])) # []
print(Solution().findSubstring("barfoofoobarthefoobarman", ["bar","foo","the"])) # [6,9,12]
