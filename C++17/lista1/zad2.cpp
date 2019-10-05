#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    cout << R"(surowy \n napis)"
         << "\n";
    cout << R"("))"
         << "\n";
    cout << R"(")(" asdf ")"
         << "\n";
    return 0;
}

//Raw string ignoruje "\"
//R"()"