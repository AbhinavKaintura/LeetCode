#include <iostream>
#include <string>
#include <stack>
#include <cctype>

using namespace std;

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

int main() {
    Solution solution;
    
    // Test cases
    string test1 = "A man, a plan, a canal: Panama";
    string test2 = "race a car";
    string test3 = "Was it a car or a cat I saw?";
    string test4 = "No 'x' in Nixon";
    
    // Run tests and print results
    cout << "Test 1: \"" << test1 << "\" is " 
         << (solution.isPalindrome(test1) ? "a palindrome" : "not a palindrome") << endl;
    
    cout << "Test 2: \"" << test2 << "\" is " 
         << (solution.isPalindrome(test2) ? "a palindrome" : "not a palindrome") << endl;
    
    cout << "Test 3: \"" << test3 << "\" is " 
         << (solution.isPalindrome(test3) ? "a palindrome" : "not a palindrome") << endl;
    
    cout << "Test 4: \"" << test4 << "\" is " 
         << (solution.isPalindrome(test4) ? "a palindrome" : "not a palindrome") << endl;
    
    // Add your own custom test
    string customTest;
    cout << "\nEnter a string to check if it's a palindrome: ";
    getline(cin, customTest);
    
    cout << "Your string is " 
         << (solution.isPalindrome(customTest) ? "a palindrome" : "not a palindrome") << endl;
    
    return 0;
}