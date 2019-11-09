const readline = require('readline');
rl.on('line', (input) => {
    console.log(`Received: ${input}`);
});

rl.close();