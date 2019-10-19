#include <iostream>
#include <set>
using namespace std;

int main() {
    using ss = set<string>;                     //alias
    ss imiona{"trent", "alexander", "arnold"};  //jawna inicjalizacja
    for (auto imie : imiona) {                  //iteracja po zbiorze
        cout << imie << "\n";
    }
    //&&i - r-value

    return 0;
}