-- Igor Malgrab
-- zadanie 1

data Tree a =  Leaf a | Node (Tree a) (Tree a)
    deriving (Eq,Ord,Show,Read)

isBalanced :: Tree a -> Bool
isBalanced (Leaf _) = True
isBalanced (Node l r) = isBalanced l && isBalanced r && abs(numOfLeaves l - numOfLeaves r) <= 1 where
    numOfLeaves (Leaf _) = 1
    numOfLeaves (Node l r) = numOfLeaves l + numOfLeaves r

test1 = isBalanced (Node (Node (Leaf 4) (Node (Leaf 3) (Leaf 2))) (Node (Leaf 6) (Node (Node (Leaf 1) (Leaf 0)) (Leaf 7)))) --false
test2 = isBalanced (Leaf 2) --true
test3 = isBalanced (Node (Node (Leaf 1) (Leaf 2)) (Node (Leaf 3) (Leaf 4))) --true

--zadanie 2

split :: [a] -> ([a], [a])
split xs =
    let n = (length xs) in
    if n `mod` 2 == 0
        then splitAt (n `div` 2) xs
        else splitAt ((n+1) `div` 2) xs

balance :: [a] -> Tree a
balance [] = error "Couldn't convert an empty list into a balanced tree"
balance [h] = Leaf h
balance xs = 
    let xs1 = fst (split xs)
        xs2 = snd (split xs)
        in Node (balance xs1) (balance xs2)

test4 = balance [1,2,3,4,5]
test5 = isBalanced (balance [1,2,3,4,5,6,7])
test6 = isBalanced (balance [10,8,6,4])

--zadanie 3

data BTree a  = BLeaf | BNode (BTree a) a (BTree a)
    deriving (Eq, Ord, Show, Read)

--a

isNodeInternal :: BTree a -> Bool
isNodeInternal BLeaf = False
isNodeInternal (BNode BLeaf _ BLeaf) = False
isNodeInternal (BNode l _ r) = True

internalPathLength :: BTree a -> Int
internalPathLength t = aux t 0 where
    aux BLeaf _ = 0
    aux (BNode BLeaf _ BLeaf) _ = 0
    aux (BNode l _ r) acc =
        if (isNodeInternal l) && (isNodeInternal r) 
            then 2 * (1 + acc) + (aux l $! acc+1) + (aux r $! acc+1)
            else if (isNodeInternal l)
                then 1 + acc + (aux l $! acc+1)
                else if (isNodeInternal r)
                    then 1 + acc + (aux r $! acc+1)
                    else (aux l $! acc+1) + (aux r $! acc+1)

tr = BNode (BNode (BNode BLeaf 5 BLeaf) 7 (BNode BLeaf 9 BLeaf)) 4 (BNode BLeaf 10 BLeaf)

tr2 = 
    BNode 
    (BNode (BNode BLeaf 8 BLeaf) 7 (BNode BLeaf 9 (BNode BLeaf 11 BLeaf)))
    3
    (BNode (BNode BLeaf 4 BLeaf) 23 (BNode (BNode BLeaf 7 BLeaf) 32 (BNode BLeaf 5 BLeaf)))

tr3 = 
    BNode
        (BNode
            (BNode (BNode (BNode BLeaf 15 BLeaf) 7 BLeaf) 3 (BNode (BNode BLeaf 16 BLeaf) 8 BLeaf))
            1
            (BNode (BNode (BNode BLeaf 17 BLeaf) 9 BLeaf) 4 (BNode (BNode BLeaf 18 BLeaf) 10 BLeaf)))
        0
        (BNode
            (BNode (BNode (BNode BLeaf 19 BLeaf) 11 BLeaf) 5 (BNode (BNode BLeaf 20 BLeaf) 12 BLeaf))
            2
            (BNode (BNode (BNode BLeaf 21 BLeaf) 13 BLeaf) 6 (BNode (BNode BLeaf 22 BLeaf) 14 BLeaf)))

a = internalPathLength tr
b = internalPathLength tr2
c = internalPathLength tr3

--b

isLeaf :: BTree a -> Bool
isLeaf (BNode BLeaf _ BLeaf) = True
isLeaf _ = False

externalPathLength :: BTree a -> Int
externalPathLength t = aux t 0 where
    aux BLeaf _ = 0
    aux (BNode l _ r) acc = 
        if isLeaf l && isLeaf r then
            2 * (1 + acc) else
                if isLeaf l then
                    1 + acc + (aux r (acc+1)) else
                        if isLeaf r then
                            1 + acc + (aux l (acc+1)) else
                                (aux l (acc+1)) + (aux r (acc+1))


d = externalPathLength tr
e = externalPathLength tr2
f = externalPathLength tr3


--zadanie 4

data MtreeL a = MTL a [MtreeL a]
    deriving (Eq, Ord, Show, Read)


preorder :: MtreeL a -> [a]
preorder (MTL v xs) = 
    v:(iter xs) where
    iter ls = case ls of
        [] -> []
        (MTL w ls):xs -> w:(iter ls)++(iter xs)


drzewo = MTL 1 [MTL 2 [], MTL 3 [], MTL 4 []]
drzewo2 = MTL 1 [MTL 2 [MTL 5 [], MTL 6 [MTL 7 [], MTL 8 [], MTL 9 []]], MTL 3 [], MTL 4 [MTL 10 []]]


