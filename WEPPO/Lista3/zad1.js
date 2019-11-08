const dog = {
    _name: 'Boomer',
    showInfo() {
        console.log(`This dog\'s name is ${this.name}`);
    },
    get name() {
        return this._name;
    },
    set name(n) {
        dog._name = n;
    }
}

Object.defineProperty(dog, '_sound', {
    value: 'woof',
    writable: true
});

Object.defineProperty(dog, 'showInfo', {
    value: function () {
        console.log(`This dog\'s name is ${this.name} and it says ${this.sound}`);
    }
})

Object.defineProperty(dog, 'sitDown', {
    value: function () {
        console.log(`${this.name}'s sat down`);
    }
})

Object.defineProperty(dog, 'sound', {
    get: function () {
        return this._sound;
    },
    set: function (s) {
        this._sound = s;
    }
});

dog.showInfo();
dog.sitDown();
dog.sound = 'quack';
dog.name = 'Frances';
dog.showInfo();

//co do pola - wystarczyłoby dog.Weight = 12.5
//co do metody - dog.layDown = () => {console.log(`${this.name}'s laid down`)}
//co do get/set - nie da rady