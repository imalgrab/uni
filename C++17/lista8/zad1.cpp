#include <iostream>
#include <regex>

using namespace std;

int main(int argc, char const *argv[]) {
    //regex for the time (hh:mm:ss or hh:mm) \\d [0-9]
    regex r("(0\\d|1\\d|2[0-3]):([0-5]\\d)(:[0-5]\\d)?");
    for (int i = 0; i < argc; i++) {
        cout << argv[i] << " : " << regex_match(argv[i], r) << "\n";
    }
    return 0;
}
