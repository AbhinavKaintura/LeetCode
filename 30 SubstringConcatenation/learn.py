class Solution:
    # Approach 1: Brute Force with Permutations
    def findSubstring_bruteforce(self, s: str, words: list[str]) -> list[int]:
        # Generate all possible permutations of words
        from itertools import permutations
        
        result = []
        word_len = len(words[0])
        total_len = word_len * len(words)
        
        # Generate all permutations of words
        word_perms = [''.join(perm) for perm in permutations(words)]
        
        # Check all possible starting indices
        for i in range(len(s) - total_len + 1):
            substring = s[i:i+total_len]
            if substring in word_perms:
                result.append(i)
        
        return result

    # Approach 2: Sliding Window with Hash Map
    def findSubstring_sliding_window(self, s: str, words: list[str]) -> list[int]:
        if not s or not words:
            return []
        
        word_len = len(words[0])
        total_len = word_len * len(words)
        word_count = {}
        
        # Count frequency of each word
        for word in words:
            word_count[word] = word_count.get(word, 0) + 1
        
        result = []
        
        # Try starting at each possible index
        for i in range(len(s) - total_len + 1):
            seen = {}
            valid = True
            
            # Check each word-sized chunk
            for j in range(len(words)):
                start = i + j * word_len
                word = s[start:start + word_len]
                
                # If word not in original word list, break
                if word not in word_count:
                    valid = False
                    break
                
                # Track frequency of words seen
                seen[word] = seen.get(word, 0) + 1
                
                # If we've seen more of this word than in original list, break
                if seen[word] > word_count[word]:
                    valid = False
                    break
            
            # If all checks pass, it's a valid starting index
            if valid:
                result.append(i)
        
        return result

    # Approach 3: Optimized Sliding Window
    def findSubstring_optimized(self, s: str, words: list[str]) -> list[int]:
        if not s or not words:
            return []
        
        word_len = len(words[0])
        total_len = word_len * len(words)
        word_count = {}
        
        # Count frequency of each word
        for word in words:
            word_count[word] = word_count.get(word, 0) + 1
        
        result = []
        
        # Optimization: Only check specific starting points
        for start in range(word_len):
            left = start
            count = {}
            matched = 0
            
            # Sliding window across the string
            for right in range(start, len(s) - word_len + 1, word_len):
                word = s[right:right + word_len]
                
                # If word is valid
                if word in word_count:
                    count[word] = count.get(word, 0) + 1
                    matched += 1
                    
                    # If we've seen too many of this word, shrink window
                    while count[word] > word_count[word]:
                        left_word = s[left:left + word_len]
                        count[left_word] -= 1
                        matched -= 1
                        left += word_len
                
                # Reset if word not in original list
                else:
                    count.clear()
                    matched = 0
                    left = right + word_len
                
                # Check if we have a valid concatenation
                if matched == len(words):
                    result.append(left)
        
        return result