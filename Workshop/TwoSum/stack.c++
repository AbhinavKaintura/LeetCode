class Solution {
    public:
        bool isPalindrome(string s) {
            // Clean the string
            string cleaned = "";
            for (char c : s) {
                if (isalnum(c)) {
                    cleaned += tolower(c);
                }
            }
            
            if (cleaned.empty()) return true;
            
            stack<char> stk;
            int mid = cleaned.length() / 2;
            
            // Push first half of characters onto stack
            for (int i = 0; i < mid; i++) {
                stk.push(cleaned[i]);
            }
            
            // Skip middle character if string length is odd
            int start = cleaned.length() % 2 == 0 ? mid : mid + 1;
            
            // Compare second half with popped elements from stack
            for (int i = start; i < cleaned.length(); i++) {
                if (stk.top() != cleaned[i]) {
                    return false;
                }
                stk.pop();
            }
            
            return true;
        }
    };