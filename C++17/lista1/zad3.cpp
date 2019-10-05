#include <iostream>
#include <set>
using namespace std;

int main() {
    using ss = set<string>;               //alias
    ss imiona{"jan", "robert", "marek"};  //jawna inicjalizacja
    for (auto imie : imiona) {            //iteracja po zbiorze
        cout << imie << "\n";
    }

    return 0;
}