#include <algorithm>
#include <ctime>
#include <fstream>
#include <iostream>
#include <random>

using namespace std;

template <typename T>
void rand_perm(T arr[], int n) {
    default_random_engine dre;
    dre.seed(time(NULL));
    uniform_int_distribution<int> uid(0, n - 1);
    for (int i = 0; i < n; i++) {
        swap(arr[i], arr[uid(dre)]);
    }
}
void uni(int n) {
    random_device rd;                                //Will be used to obtain a seed for the random number engine
    mt19937 gen(rd());                               //Standard mersenne_twister_engine seeded with rd()
    uniform_real_distribution<float> urd(1.0, 2.0);  // [a, b)
    ofstream file;
    file.open("uni.csv");
    for (int i = 0; i < n; i++) {
        file << urd(gen) << "\n";
    }
    file.close();
}
void bin(int n) {
    default_random_engine dre;
    random_device rd;
    dre.seed(rd());
    binomial_distribution<int> bd(1000, 0.5);
    ofstream file;
    file.open("bin.csv");
    for (int i = 0; i < n; i++) {
        file << bd(dre) << "\n";
    }
    file.close();
}
void norm(int n) {
    default_random_engine dre;
    random_device rd;
    dre.seed(rd());
    normal_distribution<double> nd;
    ofstream file;
    file.open("norm.csv");
    for (int i = 0; i < n; i++) {
        file << nd(dre) << "\n";
    }
    file.close();
}

int main() {
    //zad 1.
    int t[] = {1, 2, 3, 4, 5};
    rand_perm(t, sizeof(t) / sizeof(t[0]));
    for (int i = 0; i < sizeof(t) / sizeof(t[0]); i++) {
        cout << t[i] << "  ";
    }

    //zad 2.
    uni(1000);
    bin(1000);
    norm(1000);
    return 0;
}
