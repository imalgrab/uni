#include <chrono>
#include <ctime>
#include <iostream>
#include <vector>

using namespace std;

void generateMatrix(vector<vector<double>> &v) {
    for (size_t i = 0; i < v.size(); i++) {
        for (size_t j = 0; j < v[0].size(); j++) {
            double val = rand() % 16 + 5;
            val /= 20;
            v[i][j] = val;
        }
    }
}

vector<vector<double>> multiply(vector<vector<double>> &v) {
    int n = v.size();
    vector<vector<double>> x(n, vector<double>(n));
    for (size_t i = 0; i < n; i++) {
        for (size_t j = 0; j < n; j++) {
            x[i][j] = 0;
            for (size_t k = 0; k < n; k++) {
                x[i][j] += v[i][k] * v[k][j];
            }
        }
    }
    return x;
}

int main() {
    srand(time(NULL));
    vector<vector<double>> matrix10(10, vector<double>(10));
    vector<vector<double>> matrix100(100, vector<double>(100));
    vector<vector<double>> matrix1000(1000, vector<double>(1000));
    vector<vector<double>> matrix10000(10000, vector<double>(10000));
    generateMatrix(matrix10);
    generateMatrix(matrix100);
    generateMatrix(matrix1000);
    generateMatrix(matrix10000);

    chrono::duration<double> sumOfTimes(0);
    for (size_t i = 0; i < 10; i++) {
        auto timeStart = chrono::high_resolution_clock::now();
        matrix100 = multiply(matrix100);
        auto timeEnd = chrono::high_resolution_clock::now();
        sumOfTimes += chrono::duration_cast<chrono::duration<double>>(timeEnd - timeStart);
    }
    double avgTime = sumOfTimes.count() / 10;
    cout << avgTime << "\n";

    chrono::duration<double> timeFor1000;
    auto timeStart = chrono::high_resolution_clock::now();
    matrix1000 = multiply(matrix1000);
    auto timeEnd = chrono::high_resolution_clock::now();
    timeFor1000 = chrono::duration_cast<chrono::duration<double>>(timeEnd - timeStart);
    cout << timeFor1000.count() << "\n";

    return 0;
}