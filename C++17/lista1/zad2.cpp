#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    cout << R"(surowy \n napis)"
         << "\n";
    cout << "surowy \n napis"
         << "\n";
    cout << R"("))"
         << "\n";
    cout << R"asdf8()")asdf8"
         << "\n";
    return 0;
}

//Raw string ignoruje "\"
//R"()"
//identyfikator R