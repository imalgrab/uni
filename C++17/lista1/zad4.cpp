#include <cstdint>
#include <iostream>

using namespace std;

//silnie stypizowany enum: wlasny zakres wiazania oraz niepodatnosc na konwersje na liczby calkowite

enum class imiona : uint16_t {
    anna,
    dorota,
    karolina,
    eryk,
    jan = 6,
    roman,
    zbigniew
};

void wiadomosc(string w, imiona i) {
    cout << "Wiadomosc do ";
    switch (i) {
        case imiona::anna:
            cout << "Anny: \n";
            break;
        case imiona::dorota:
            cout << "Doroty: \n";
            break;
        case imiona::karolina:
            cout << "Karoliny: \n";
            break;
        case imiona::eryk:
            cout << "Eryka: \n";
            break;
        case imiona::jan:
            cout << "Jana: \n";
            break;
        case imiona::roman:
            cout << "Romana: \n";
            break;
        case imiona::zbigniew:
            cout << "Zbigniewa: \n";
            break;
    }
    cout << w << "\n";
}

int main(int argc, char const *argv[]) {
    wiadomosc("Milego dnia", imiona::jan);
    return 0;
}
