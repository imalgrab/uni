#include <iostream>

using namespace std;

template <int n, int k>
struct BinomialCoeff {
    static constexpr int value = BinomialCoeff<n - 1, k - 1>::value * n / k;
};

template <>
struct BinomialCoeff<0, 0> {
    static constexpr int value = 1;
};

template <int n>
struct BinomialCoeff<n, 0> {
    static constexpr int value = 1;
};

// template <int n>
// struct BinomialCoeff<n, n> {
//     static constexpr int value = 1;
// };

int main() {
    BinomialCoeff<30, 8> bc;
    cout << bc.value << "\n";
    return 0;
}