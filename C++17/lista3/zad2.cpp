#include <iostream>
#include <limits>

using namespace std;

int main() {
    cout << "najblizsze +0 float : " << numeric_limits<float>::min() << "\n";
    cout << "najblizsze -0 float : " << -numeric_limits<float>::min() << "\n";
    cout << "max float : " << numeric_limits<float>::max() << "\n";
    cout << "roznica miedzy 1 a najmniejsza <=1 : " << numeric_limits<float>::epsilon() << "\n";
    cout << "\n";
    cout << "najblizsze +0 double : " << numeric_limits<double>::min() << "\n";
    cout << "najblizsze -0 double : " << -numeric_limits<double>::min() << "\n";
    cout << "max double : " << numeric_limits<double>::max() << "\n";
    cout << "roznica miedzy 1 a najmniejsza <=1 : " << numeric_limits<double>::epsilon() << "\n";
    return 0;
}