function sum() {
    let s = 0;
    for (let i = 0; i < arguments.length; i++) {
        s += arguments[i];
    }
    console.log(s);
}
sum(1, 2, 3);
// 6
sum(1, 2, 3, 4, 5);
// 15
