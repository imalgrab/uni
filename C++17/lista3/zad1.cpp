#include <iostream>
#include <limits>

using namespace std;

int main() {
    cout << "min : " << numeric_limits<long long>::min() << "\n";
    cout << "max : " << numeric_limits<long long>::max() << "\n";
    cout << " # bitow : " << numeric_limits<long long>::digits << "\n";
    cout << " # cyfr : " << numeric_limits<long long>::digits10 << "\n";
    return 0;
}