-- Igor Malgrab
-- zadanie 3

data BTree a  = BLeaf | BNode (BTree a) a (BTree a)
    deriving (Eq, Ord, Show, Read)

-- a

isNode :: BTree a -> Bool
isNode (BNode _ _ _) = True
isNode _ = False

iPLength :: BTree a -> Int
iPLength tree = aux tree 0  where
    aux BLeaf _ = 0
    aux (BNode l _ r) acc = 
        if (isNode l) && (isNode r)
            then 2*(1 + acc) + (aux l (acc+1)) + (aux r (acc+1))
            else if (isNode l)
                then 1 + acc + (aux l (acc+1))
                else if (isNode r)
                    then 1 + acc + (aux r (acc+1)) 
                    else 0

-- b

isLeaf :: BTree a -> Bool
isLeaf BLeaf = True
isLeaf _ = False

ePLength :: BTree a -> Int
ePLength tree = aux tree 0 where
    aux BLeaf _ = 0
    aux (BNode l _ r) acc = 
        if (isLeaf l) && (isLeaf r)
            then 2*(1+acc)
            else if (isLeaf l)
                then 1 + acc + (aux r (acc+1))
                else if (isLeaf r)
                    then 1 + acc + (aux l (acc+1)) 
                    else (aux l (acc+1)) + (aux r (acc+1))

tr = BNode (BNode (BNode BLeaf 5 BLeaf) 7 (BNode BLeaf 9 BLeaf)) 4 (BNode BLeaf 10 BLeaf)
tr2 = BNode (BNode BLeaf 9 BLeaf) 10 (BNode BLeaf 11 BLeaf)
tr3 = BNode (BNode BLeaf 200 (BNode BLeaf 300 BLeaf)) 100 BLeaf

test = iPLength tr
test' = ePLength tr

test1 = iPLength tr2
test1' = ePLength tr2

test2 = iPLength tr3
test2' = ePLength tr3
