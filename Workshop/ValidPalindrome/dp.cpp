#include <iostream>
#include <string>
#include <cctype>

using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !isalnum(s[left])) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !isalnum(s[right])) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (tolower(s[left]) != tolower(s[right])) {
                return false;
            }
            
            left++;
            right--;
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