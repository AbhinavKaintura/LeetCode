#include <iostream>
using namespace std;

int main() {
    int n, t1 = 0, t2 = 1, nextTerm = 0;

    cout << "Enter the number of terms: ";
    cin >> n;

    cout << "Fibonacci Series: ";

    // Print the first two terms which are already known
    if (n >= 1)
        cout << t1 << " ";
    if (n >= 2)
        cout << t2 << " ";

    // Generate and print the next terms
    for (int i = 3; i <= n; ++i) {
        nextTerm = t1 + t2;
        cout << nextTerm << " ";
        t1 = t2;
        t2 = nextTerm;
    }
    
    cout << endl;
    return 0;
}