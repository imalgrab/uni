const res = new Set();
for (let i = 1; i <= 100000; i++) {
    let number = i;
    let cond = true;
    let sum = 0;
    while (number != 0) {
        let digit = number % 10;
        sum += digit;
        if (i % digit != 0) {
            cond = false;
            break;
        }
        number = Math.floor(number / 10);
    }
    if (cond && i % sum == 0) {
        res.add(i);
    }
}

console.log(res.size);