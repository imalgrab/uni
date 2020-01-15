#include <iostream>
#include <regex>

using namespace std;

int main(int argc, char const *argv[]) {
    regex r("([A-Z][a-z]{2,}( *)+)+");

    cout << regex_match("Maladjsfkdsj Wies Duza-Wies", r);
    return 0;
}
