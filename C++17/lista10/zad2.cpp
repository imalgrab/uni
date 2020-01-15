#include <algorithm>
#include <iostream>
#include <list>

using namespace std;

class RgbPoint {
   private:
    double x, y;
    int r, g, b;
    string name;

   public:
    RgbPoint(double cx, double cy, int rx, int gx, int bx, string n);
    double getX();
    double getY();
    int getR();
    int getG();
    int getB();
    double getLuminance();
    friend ostream& operator<<(ostream& os, const RgbPoint& rgbp);
};

RgbPoint::RgbPoint(double cx, double cy, int rx, int gx, int bx, string n) {
    x = cx;
    y = cy;
    r = rx;
    g = gx;
    b = bx;
    name = n;
}

double RgbPoint::getX() {
    return x;
}

double RgbPoint::getY() {
    return y;
}

double RgbPoint::getLuminance() {
    return 0.2126 * r + 0.7152 * g + 0.0722 * b;
}

ostream& operator<<(ostream& os, const RgbPoint& rgbp) {
    os << rgbp.name << " : (" << rgbp.x << "," << rgbp.y << ")";
    return os;
}

int main() {
    list<RgbPoint> rgbs{
        RgbPoint(3.0, 3.0, 0, 1, 1, "a"),          //I
        RgbPoint(-3.0, 3.0, 0, 2, 3, "b"),         //II
        RgbPoint(-3.0, -3.0, 0, 0, 0, "c"),        //III
        RgbPoint(3.0, -3.0, 255, 255, 255, "d")};  //IV

    list<RgbPoint> fst;
    list<RgbPoint> snd;
    list<RgbPoint> trd;
    list<RgbPoint> frt;

    copy_if(rgbs.begin(), rgbs.end(), back_inserter(fst), [](RgbPoint p) { return p.getX() > 0 && p.getY() > 0; });
    copy_if(rgbs.begin(), rgbs.end(), back_inserter(snd), [](RgbPoint p) { return p.getX() < 0 && p.getY() > 0; });
    copy_if(rgbs.begin(), rgbs.end(), back_inserter(trd), [](RgbPoint p) { return p.getX() < 0 && p.getY() < 0; });
    copy_if(rgbs.begin(), rgbs.end(), back_inserter(frt), [](RgbPoint p) { return p.getX() > 0 && p.getY() < 0; });

    RgbPoint brightest = *max_element(rgbs.begin(), rgbs.end(), [](RgbPoint p, RgbPoint q) { return p.getLuminance() < q.getLuminance(); });
    RgbPoint darkest = *min_element(rgbs.begin(), rgbs.end(), [](RgbPoint p, RgbPoint q) { return p.getLuminance() < q.getLuminance(); });

    cout << brightest << "\n"
         << darkest << "\n";
    return 0;
}