function fib() {
    let fn1 = 0;
    let fn2 = 1;
    return {
        next: function () {
            let tmp = fn1;
            fn1 = fn2;
            fn2 = tmp + fn1;
            return {
                value: tmp,
                done: false
            }
        }
    }
}

function* fibonacci() {
    let fn1 = 0;
    let fn2 = 1;
    while (true) {
        let tmp = fn1;
        fn1 = fn2;
        fn2 = tmp + fn1;
        yield tmp;
    }
}

var _it = fib();
// for (var _result; _result = _it.next(), !_result.done;) {
//     console.log(_result.value);
// }

// var _it2 = fibonacci();
// for (const fi of _it2) {
//     console.log(fi);
// }