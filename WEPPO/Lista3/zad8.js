function* fib() {
    let fn1 = 0;
    let fn2 = 1;
    while (true) {
        let tmp = fn1;
        fn1 = fn2;
        fn2 = tmp + fn1;
        yield tmp;
    }
}

function* take(it, top) {
    let i = 0;
    while (i < 10) {
        yield it.next();
        i++;
    }
    return;
}
// zwróć dokładnie 10 wartości z potencjalnie
// "nieskończonego" iteratora/generatora
for (let num of take(fib(), 10)) {
    console.log(num);
}
