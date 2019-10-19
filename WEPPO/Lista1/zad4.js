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

console.log(
    fibIter(5));