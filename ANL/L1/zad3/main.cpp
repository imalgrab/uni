#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    int i = 0;
    double result = 0.0;

    while(abs(M_PI - 4 * result) >= pow(10, -5))
    {
        result += (pow(-1.0, i) / (2*i + 1.0));
        i++;
    }

    cout << i << endl;
}


