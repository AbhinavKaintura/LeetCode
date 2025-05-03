using namespace std;
#include <vector>
#include <algorithm>
#include <iostream>

class Solution {
    public: 
    int maxProfit(vector<int> & prices) {

        int minPrice = prices[0];
        int maxProfit = 0;
        int n = prices.size();

        for(int i = 1; i < n; i++){

            if (prices[i] < minPrice) 
                minPrice = prices[i];
            
            maxProfit = std::max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;

    }
};

int main() {
    Solution sol;
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << "Max Profit : " << sol.maxProfit(prices) << endl;
    return 0;

}