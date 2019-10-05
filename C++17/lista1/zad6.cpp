#include <cmath>
#include <iostream>

using namespace std;

void mz(int a, int b, int c) {
    if (auto delta = b * b - 4 * a * c; delta >= 0) {
        if (delta == 0) {
            cout << "delta = 0, pierw. podwojny: " << -b / 2 * a << "\n";
        } else {
            cout << "delta > 0, jeden z pierw. " << (-b - sqrt(delta)) / 2 * a << "\n";
        }

    } else {
        cout << "delta < 0, brak pierwiastkow\n";
    }
}

int main() {
    mz(1, 3, 1);
    mz(5, 6, -1);
    return 0;
}