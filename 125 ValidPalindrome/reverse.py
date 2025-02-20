#solu1: using reverse
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Convert to lowercase and remove non-alphanumeric characters
        processed = ''.join(char.lower() for char in s if char.isalnum())
        
        # Sort both the string and its reverse
        sorted_str = ''.join(processed)
        sorted_reverse = ''.join(processed[::-1])
        
        print(sorted_str)
        print(sorted_reverse)

        # Compare if they are equal
        return sorted_str == sorted_reverse


print(Solution().isPalindrome("A man, a plan, a canal: Panama"))
