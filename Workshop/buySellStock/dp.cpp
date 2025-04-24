#include <iostream>
#include <vector>
#include <climits>

using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int min_price = INT_MAX;
        int max_profit = 0;
        
        for (int price : prices) {
            if (min_price > price) {
                min_price = price;
            }
            
            int profit = price - min_price;
            
            if (profit > max_profit) {
                max_profit = profit;
            }
        }
        
        return max_profit;
    }
};

int main() {
    Solution solution;
    
    // Test case 1
    vector<int> prices1 = {7, 1, 5, 3, 6, 4};
    cout << "Test Case 1: [7, 1, 5, 3, 6, 4]\n";
    cout << "Output: " << solution.maxProfit(prices1) << " (Expected: 5)\n";
    
    // Test case 2
    vector<int> prices2 = {7, 6, 4, 3, 1};
    cout << "\nTest Case 2: [7, 6, 4, 3, 1]\n";
    cout << "Output: " << solution.maxProfit(prices2) << " (Expected: 0)\n";
    
    // Add custom test case input
    cout << "\nEnter the number of prices: ";
    int n;
    cin >> n;
    
    vector<int> custom_prices(n);
    cout << "Enter " << n << " prices separated by spaces: ";
    for (int i = 0; i < n; i++) {
        cin >> custom_prices[i];
    }
    
    cout << "Maximum profit: " << solution.maxProfit(custom_prices) << "\n";
    
    return 0;
}