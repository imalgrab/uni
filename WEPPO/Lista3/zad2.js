const fibIter = (n) => {
    let a1 = 0;
    let a2 = 1;
    for (let i = 0; i < n; i++) {
        let t = a1;
        a1 = a2;
        a2 = a1 + t;
    }
    return a1;
}

const fibRec = (n) => {
    if (n == 1) {
        return 0;
    }
    if (n == 2) {
        return 1;
    }
    return fibRec(n - 1) + fibRec(n - 2);
}

const fibMemo = (fibRec) => {
    let cache = {};
    return function (n) {
        if (n in cache) {
            return cache[n];
        } else {
            let res = fibRec(n);
            cache[n] = res;
            return res;
        }
    }
}

for (let i = 10; i <= 42; i++) {
    console.time('fibRec : ' + i);
    fibRec(i);
    console.timeEnd('fibRec : ' + i);
    console.time('fibIter : ' + i);
    fibIter(i);
    console.timeEnd('fibIter : ' + i);
    console.time('fibMemo : ' + i);
    fibMemo(i);
    console.timeEnd('fibMemo : ' + i);
    console.log();
}
