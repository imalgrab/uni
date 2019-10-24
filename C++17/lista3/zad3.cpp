#include <ctime>
#include <iostream>
#include <random>
#include <ratio>

using namespace std;

int main() {
    srand(time(NULL));
    typedef ratio<1, 1> one;
    typedef ratio_add<one, ratio<1, 2>> half;
    typedef ratio_add<half, ratio<1, 3>> onethird;
    typedef ratio_add<onethird, ratio<1, 4>> onefourth;
    typedef ratio_add<onefourth, ratio<1, 5>> onefifth;

    cout << onefifth::num << " / " << onefifth::den << "\n";

    return 0;
}