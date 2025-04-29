#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
    
            //sliding window
    
            int left =0;
            int n = s.length();
            int maxLen = 0;
            unordered_map<char, int> charMap;
    
            for (int right=0; right<n; right++){
    
                while(charMap.find(s[right]) != charMap.end() && charMap[s[right]] >= left ){
                    left = charMap[s[right]]+1;
                }
                charMap[s[right]] = right;
                maxLen = max(maxLen, right-left+1);
            }
            return maxLen;
        }
    };

int main() {
    string s = "abcabcbb";
    Solution sol;
    cout << "Answer: " << sol.lengthOfLongestSubstring(s) << endl;
    return 0;
}