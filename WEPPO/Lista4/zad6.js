const fs = require('fs');
const path = String.raw`D:\Uniwersytet\II-UWR\WEPPO\Lista4\input.txt`;
fs.readFile(path, function read(err, data) {
    if (err) {
        throw err;
    }
    console.log(data.toString());
})