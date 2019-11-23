#include <iostream>
#include <list>
#include <set>
#include <utility>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]) {
    vector<double> v = {1.25, 3.14, 7.6, 4.2, 31.11, 7.2, 0.3, 0.15, 492.4};
    list<string> l = {"banan", "ananas", "gruszka", "malina", "pomidor"};
    set<int> s = {4, 2, 7, 3, 100, 33, 1, 0, 55};

    //zad. 1
    [](set<int> s, int a, int b) {
        set<int>::iterator i;
        for (i = s.begin(); i != s.end(); i++) {
            int curr = *i;
            if (a < curr && curr < b) {
                cout << curr << "\t";
            }
        }
        cout << "\n";
    }(s, -5, 53);

    [](list<string> l, string a, string b) {
        list<string>::iterator i;
        for (i = l.begin(); i != l.end(); i++) {
            string curr = *i;
            if (a < curr && curr < b) {
                cout << curr << "\t";
            }
        }
        cout << "\n";
    }(l, "agrest", "kiwi");

    //zad.2
    [](vector<double> v, int k, int p) {
        for (int i = p; i < v.size(); i += k) {
            cout << v[i] << "\t";
        }
        cout << "\n";
    }(v, 3, 1);

    [](list<string> l, int k, int p) {
        list<string>::iterator i;
        int idx = 0;
        for (i = l.begin(); i != l.end(); i++) {
            if (idx >= p && (idx - p) % k == 0) {
                cout << *i << "\t";
            }
            idx++;
        }
        cout << "\n";
    }(l, 2, 0);

    //zad.3
    [](vector<double> v) {
        int s = 0;
        // for (int i = 0; i < v.size(); i++) {
        //     s += v[i];
        // }
        for (auto &&k : v) {
            s += k;
        }

        cout << s * 1.0f / v.size() << "\n";
    }(v);

    //zad.4
    [](vector<double> v) {
        vector<double>::iterator largest = v.begin();
        vector<double>::iterator smallest = v.begin();
        vector<double>::iterator i;
        for (i = v.begin(); i != v.end(); i++) {
            if (*i < *smallest) {
                smallest = i;
            } else if (*i > *largest) {
                largest = i;
            }
        }
        cout << *smallest << " : " << *largest << "\n";
        return make_pair(smallest, largest);
    }(v);

    //zad. 5
    [](set<int> s) {
        set<int>::iterator i;
        int sum = 0;
        for (i = s.begin(); i != s.end(); i++) {
            sum += *i;
        }
        cout << sum << "\n";
        return sum;
    }(s);

    [](list<string> l) {
        list<string>::iterator i;
        string res = "";
        for (i = l.begin(); i != l.end(); i++) {
            res += *i;
        }
        cout << res << "\n";
        return res;
    }(l);

    return 0;
}