function forEach(a, f) {
    for (let i = 0; i < a.length; i++) {
        f(a[i]);
    }
}
function map(a, f) {
    for (let i = 0; i < a.length; i++) {
        a[i] = f(a[i]);
    }
}
function filter(a, f) {
    let i = 0;
    while (i < a.length) {
        if (f(a[i])) {
            i++;
        }
        else {
            a.splice(i, 1);
        }
    }
}
var a = [1, 2, 3, 4];
forEach(a, _ => { console.log(_); });
map(a, _ => _ * 2);
console.log(a);
filter(a, _ => _ < 3);
console.log(a);

//postać zwykła: function() => {}...
//lambda wyrażenie: (x) => x*3