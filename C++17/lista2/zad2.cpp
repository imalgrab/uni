#include <bits/stdc++.h>
#include <iostream>
#include <vector>

using namespace std;

//klasa opakowujaca - zarzadza
//shared_ptr - przypisac wskaznik do kilku wlascicieli
//wskaznik usuwany, gdy wszyscy wlasciciele oddadza wladze

class line_writer {
   private:
    ofstream *o;

   public:
    line_writer(ofstream *);
    ~line_writer();
    void writeToFile(vector<string>);
};

line_writer::line_writer(ofstream *of) {
    o = of;
}

line_writer::~line_writer() {
    o->close();
}

void line_writer::writeToFile(vector<string> msg) {
    for (auto &line : msg) {
        *o << line << "\n";
    }
}
int main() {
    ofstream *o = new ofstream();
    o->open("out.txt", ios::app);
    line_writer *lw = new line_writer(o);
    lw->writeToFile(vector<string>{"Czytaj ksiazki", "Pisz tylko zdania zlozone", "Polityka jest nieciekawa", "1. w kulach", "7 miliardow ludzi na Ziemi"});
    free(lw);
    auto p1 = shared_ptr<line_writer>(new line_writer(o));
    auto p2 = p1;
    auto p3 = p1;
    p1->writeToFile({"a"});
    p2->writeToFile({"b"});
    p3->writeToFile({"c"});
    return 0;
}