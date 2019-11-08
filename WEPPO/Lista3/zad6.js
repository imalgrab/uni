function createGenerator(b) {
    var _state = 0;
    return {
        next: function () {
            return {
                value: _state,
                done: _state++ >= b
            }
        }
    }
}

var baz = {
    [Symbol.iterator]() {
        return createGenerator(5);
    }
}

var foo1 = {
    [Symbol.iterator]() {
        return createGenerator(1)
    }
};
var foo2 = {
    [Symbol.iterator]() {
        return createGenerator(5)
    }
};

for (var f of foo2)
    console.log(f);