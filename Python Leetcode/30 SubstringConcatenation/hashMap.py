# HashMap

from typing import List


class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        result = []
        word_len = len(words[0])
        total_words = word_len * len(words)
        word_count = {}

        for word in words:
            word_count[word] = word_count.get(word, 0) + 1

        for i in range(len(s) - total_words + 1):

            seen = {}
            valid = True

            for j in range(len(words)):
                
                start = i + j*word_len
                word = s[start: start + word_len]

                if word not in word_count:
                    valid = False
                    break

                seen[word] = seen.get(word, 0) + 1
                if seen[word] > word_count[word]:
                    valid = False
                    break
            
            if valid:
                result.append(i)

        return result
    
print(Solution().findSubstring("barfoothefoobarman", ["foo","bar"])) # [0, 9]
print(Solution().findSubstring("wordgoodgoodgoodbestword", ["word","good","best","word"])) # []
print(Solution().findSubstring("barfoofoobarthefoobarman", ["bar","foo","the"])) # [6, 9, 12]
