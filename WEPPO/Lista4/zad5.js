process.stdin.on('readable', () => {
    let name = process.stdin.read();
    process.stdout.write(`Hello ${name}`);
})

//https://nodejs.org/api/process.html#process_process_stdin