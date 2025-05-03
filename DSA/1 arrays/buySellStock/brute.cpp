#include <vector>
#include <algorithm> // for std::max
#include <iostream>
using namespace std;

class Solution {
    public: 
    int maxProfit(vector<int> & prices) {

        int n = prices.size();
        int profit;
        if(n == 0) return 0; // No prices available
        int maxProfit = 0;

        for(int i = 1; i< n; i++) {
            for (int j = i+1; j< n; j++) {
                profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
                
            }
        }
        return maxProfit;
    }
};

int main() {
    Solution sol;
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << "Max Profit: " << sol.maxProfit(prices) << endl; // Output: 5
    return 0;
}