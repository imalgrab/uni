// weak_ptr
// shared_ptr
#include <iostream>
#include <memory>

using namespace std;

int main() {
    weak_ptr<int> w1;
    {
        auto sp1 = make_shared<int>();
        auto sp2 = sp1;
        w1 = sp1;
        cout << w1.expired() << "\n";
    }
    cout << w1.expired() << "\n";
    return 0;
}