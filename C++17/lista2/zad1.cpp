#include <cmath>
#include <cstdint>
#include <ctime>
#include <iostream>
#include <memory>
#include <vector>
#define SIZE 10000

//inteligentne wskazniki - aby programy byly wolne od wyciekow pamieci/zasobow oraz wyjatkow

//unique_ptr - tylko jeden wlasciciel, moze byc przeniesiony, ale nie skopiowany!
//It cannot be copied to another unique_ptr, passed by value to a function

using namespace std;

vector<int> primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};

class counter64 {
   private:
    uint64_t cntr = 1;

   public:
    void setCounter(int n) {
        cntr = n;
    }
    int getCounter() {
        return cntr;
    }
};

// vector<int> generatePrimes() {
//     vector<int> primes;
//     for (int i = 2; i <= SIZE; i++) {
//         bool isPrime = true;
//         for (int j = 2; j <= sqrt(i); j++) {
//             if (i % j == 0) {
//                 isPrime = false;
//                 break;
//             }
//         }
//         if (isPrime) {
//             primes.push_back(i);
//         }
//     }
//     return primes;
// }

void multiplyByIthPrime(int i, int m, int n, unique_ptr<counter64[]> &t) {
    if (i >= m) {
        return;
    }
    int rnd = rand() % n + 1;  //l. el. do przemnozenia w i-tym kroku
    while (rnd > 0) {
        int rndidx = rand() % n;  //rndidx-ty el. mnozony przez i-ta l.p.
        t[rndidx].setCounter(t[rndidx].getCounter() * primes[i - 1]);
        rnd--;
    }
    multiplyByIthPrime(i + 1, m, n, t);
}

unique_ptr<counter64[]> printVals(unique_ptr<counter64[]> cntrs, int n) {
    for (size_t i = 0; i < n; i++) {
        cout << cntrs[i].getCounter() << "  ";
    }
    return cntrs;
}

int main() {
    srand(time(NULL));
    int n = 10;
    int m = 7;
    counter64 t[n];
    unique_ptr<counter64[]> p{new counter64[n]};  //ew. auto p = make_unique<counter64[]>(n) ale wtedy nie wolno inicjowac el.
    multiplyByIthPrime(1, m, n, p);
    printVals(move(p), n);
    return 0;
}