const car = {
    brand: 'Toyota',
    'car model': 'Prius',
    2: 2018,
}

const car2 = {
    brand: 'Nissan',
    model: 'Micra',
    year: 2003,
    engine: {
        horsePower: 110,
        cc: 1198
    }
}

console.log(car.brand);
console.log(car['brand']);
console.log(car[2]);
console.log(car2[1]);

//(a)
//  dot notation - nazwa zmiennej nie moze zaczynac sie od cyfry, nie moze zawierac spacji

//(b)
//  liczba - wszystko OK, jeżeli jakiś klucz to liczba
//  inny obiekt - blad
//  wplyw - ?

//(c)
//  inne niz number - undefined
//  dopisana wlasciwosc pod kluczem, ktory nie jest liczba - zamiana w propercje
//  mozna - odpowiednio skroci lub zwiekszy tablice

const customers = ['Bob', 'Adam', 'Tom', 'Richard'];
console.log(customers['Adam']);
console.log(customers[car]);
customers['Adam'] = 49;
console.log(customers);

customers.length = 6;
console.log(customers);

customers.length = 1;
console.log(customers);



