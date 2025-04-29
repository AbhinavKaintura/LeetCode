#include <iostream>
#include <unordered_set>
#include <string>
using namespace std;


class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
    
            //sliding window
    
            int left =0;
            int n = s.length();
            int maxLen = 0;
            unordered_set<char> charSet;
    
            for (int right=0; right<n; right++){
    
                while(charSet.find(s[right]) != charSet.end()){
                    charSet.erase(s[left]);
                    left++;
                }
    
                charSet.insert(s[right]);
                maxLen = max(maxLen, right-left+1);
            }
            return maxLen;
        }
    };

int main() {
    Solution solution;
    string s = "abcabcbb";
    int result = solution.lengthOfLongestSubstring(s);
    cout << "Length of the longest substring without repeating characters: " << result << endl;
    return 0;
}