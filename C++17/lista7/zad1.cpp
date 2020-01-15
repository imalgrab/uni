#include <cmath>
#include <complex>
#include <iostream>

using namespace std;

complex<double> f(complex<double> z, int n) {
    complex<double> res(1.0, 0.0);
    for (double i = 1; i <= n; i++) {
        complex<double> num = pow(1 + 1.0 / i, z);
        complex<double> den = 1.0 + z / i;
        res *= num / den;
    }
    return res / z;
}

complex<double> fi(complex<double> z, int n) {
    complex<double> res(1.0, 0.0);
    for (double i = 1; i <= n; i++) {
        res *= (1.0 + z / i) * exp(-z / i);
    }
    return res * z * exp(0.5772156649 * z);
}

int main() {
    complex<double> test(1, 2);

    complex<double> eg = f(test, 100000);
    cout << eg << endl;

    complex<double> eg_i = fi(test, 100000);
    cout << eg_i << endl;

    cout << eg * eg_i << endl;
    return 0;
}