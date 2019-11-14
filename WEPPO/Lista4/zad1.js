const Tree = function (v, l, r) {
    this.v = v;
    this.l = l;
    this.r = r;
    
}

function* createGenerator(tree) {
    function* aux(tree) {
        if (tree == null) {
            return;
        }
        yield* aux(tree.l);
        yield tree.v;
        yield* aux(tree.r);
    }
    yield* aux(tree);
}

const t =
    new Tree(1,
        new Tree(3, null, null),
        new Tree(5,
            null,
            new Tree(7,
                new Tree(9, null, null),
                new Tree(11, null, null))));

var root = createGenerator(t);
for (var e of root) {
    console.log(e);
}