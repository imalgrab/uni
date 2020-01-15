#include <iostream>
#include <regex>

using namespace std;

int main(int argc, char const *argv[]) {
    regex r("\\(( *)-?[0-9]+(.[0-9]+)?( *)\\+( *)-?[0-9]+(.[0-9]+)?[iI]( *)\\)");
    cout << regex_match("(   -3   +   -2i    )", r) << "\n";
    cout << regex_match("(   -3. +i)", r) << "\n";
    cout << regex_match("(-3+-2i)", r) << "\n";
    return 0;
}
