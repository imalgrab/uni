#include <iostream>

using namespace std;

template <int a, int b>
struct nwd {
    static constexpr int value = nwd<b, a % b>::value;
};

template <int a>
struct nwd<a, 0> {
    static constexpr int value = a;
};

int main() {
    nwd<10, 15> n;
    cout << n.value << "\n";

    return 0;
}