#include <iostream>
#include <string>
#include <unordered_set>
using namespace std;

class Solution { 
public: 
    int lengthOfLongestSubstring(string s){

        int n = s.length();
        int maxLength = 0;

        for(int i=0; i<n; i++){
            unordered_set<char> charSet;
            for(int j=i; j<n; j++){

                if(charSet.find(s[j]) != charSet.end()){
                    break;
                }

                charSet.insert(s[j]);
                maxLength = max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }
};

int main() {
    string s = "abcabcbb";
    Solution sol;
    cout << "Answer: " << sol.lengthOfLongestSubstring(s) << endl; // Output: 3
    return 0;
}