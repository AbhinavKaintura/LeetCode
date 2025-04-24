#include <string>
class Solution {
public:
    bool isPalindrome(string s) {
        string cleaned = "";
        for (char c : s) {
            if (isalnum(c)) {
                cleaned += tolower(c);
            }
        }
        
        // Create a reversed version of the cleaned string
        string reversed = cleaned;
        reverse(reversed.begin(), reversed.end());
        
        // Compare the cleaned and reversed strings
        return cleaned == reversed;
    }
};