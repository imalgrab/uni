#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    long double tab[3];
    tab[0] = 1.0;
    tab[1] = -(1.0 / 7.0);

    for(int i = 0; i < 100; i++)
    {
        tab[2] = (13.0 / 7.0 * tab[1]) + 2.0 / 7.0 * tab[0];
        tab[0] = tab[1];
        tab[1] = tab[2];

        cout << tab[2] << endl;
    }
}


