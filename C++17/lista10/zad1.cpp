#include <algorithm>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

class GreatPole {
   private:
    string name;
    int age;
    double weight;
    double height;

   public:
    GreatPole(string n, int a, double w, double h);
    int getAge();
    double getWeight();
    double getHeight();
    double bmi();
    friend ostream& operator<<(ostream& os, const GreatPole& gp);
};

GreatPole::GreatPole(string n, int a, double w, double h) {
    name = n;
    age = a;
    weight = w;
    height = h;
}

int GreatPole::getAge() {
    return age;
}

double GreatPole::getWeight() {
    return weight;
}

double GreatPole::getHeight() {
    return height;
}

double GreatPole::bmi() {
    return weight / (height / 100 * height / 100);
}

ostream& operator<<(ostream& os, const GreatPole& gp) {
    os << gp.name << " ma " << gp.age << " lat, wazy " << gp.weight << " kg, mierzac " << gp.height << " cm";
    return os;
}

int main() {
    //nazwa, wiek, waga, wzrost
    vector<GreatPole> greatPoles{
        GreatPole("Adam Malysz", 32, 84.5, 179),
        GreatPole("Karol Wojtyla", 17, 55.3, 182.7),
        GreatPole("Robert Kubica", 42, 49.1, 163),
        GreatPole("Robert Lewandowski", 33, 88, 188),
        GreatPole("Zbigniew Stonoga", 69, 103, 171.4),
        GreatPole("Lech Walesa", 72, 101, 155),
        GreatPole("Daniel Wojcik", 21, 79, 183),
        GreatPole("Zenon Martyniuk", 66, 83.9, 172),
        GreatPole("Mariusz Pudzianowski", 39, 121, 189.4),
        GreatPole("Marcin Gortat", 40, 103, 206)};

    sort(greatPoles.begin(), greatPoles.end(), [](GreatPole x, GreatPole y) { return x.bmi() < y.bmi(); });

    for (auto gp : greatPoles) {
        cout << gp << "\n";
    }

    GreatPole oldest = *max_element(greatPoles.begin(), greatPoles.end(), [](GreatPole x, GreatPole y) { return x.getAge() < y.getAge(); });
    GreatPole heaviest = *max_element(greatPoles.begin(), greatPoles.end(), [](GreatPole x, GreatPole y) { return x.getWeight() < y.getWeight(); });
    GreatPole tallest = *max_element(greatPoles.begin(), greatPoles.end(), [](GreatPole x, GreatPole y) { return x.getHeight() < y.getHeight(); });

    cout << oldest << "\n"
         << heaviest << "\n"
         << tallest << "\n";

    return 0;
}