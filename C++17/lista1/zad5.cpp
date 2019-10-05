#include <iostream>

using namespace std;

auto lucas(int n) {
    if (n == 0) {
        return 2;
    } else if (n == 1) {
        return 1;
    } else {
        return lucas(n - 1) + lucas(n - 2);
    }
}

int main(int argc, char const *argv[]) {
    cout << lucas(10) << "\n";  //123
    return 0;
}
