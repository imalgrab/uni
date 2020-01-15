#include <iostream>
#include <regex>

using namespace std;

int main(int argc, char const *argv[]) {
    //regex for the date
    regex r("((0[1-9]|[12][0-9]|3[01])-(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-9])-02|(0[1-9]|[12][0-9]|30)-(0[469]|11))-[12][0-9][0-9][0-9]+");
    for (int i = 1; i < argc; i++) {
        cout << argv[i] << " : " << regex_match(argv[i], r) << "\n";
    }
    return 0;
}
