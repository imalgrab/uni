#include <iostream>

using namespace std;

auto lucas(int n) {
    if (n == 0) {
        return 2;
    }
    if (n == 1) {
        return 1;
    }
    return lucas(n - 1) + lucas(n - 2);
}

int main(int argc, char const *argv[]) {
    for (int i = 0; i < 10; i++) {
        cout << lucas(i) << "\n";
    }

    //iloraz 2 nast dazy do fi
    return 0;
}
