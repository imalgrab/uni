const primes = new Set();
for (let i = 2; i <= 100000; i++) {
    let isPrime = true;
    for (let j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
            isPrime = false;
            break;
        }
    }
    if (isPrime) {
        primes.add(i);
    }
}
console.log(primes.size);