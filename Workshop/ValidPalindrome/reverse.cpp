#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>
using namespace std;
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