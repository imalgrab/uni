-- Igor Malgrab

-- zad 1

data Tree a = Leaf a | Branch (Tree a) (Tree a)
 deriving (Eq, Ord, Show)

label :: Tree a -> Tree (a, Int)
label tree = fst (aux tree 0) where
    aux :: Tree a -> Int -> (Tree (a, Int), Int)
    aux (Leaf a) n = (Leaf (a, n), n+1)
    aux (Branch l r) n = (Branch leftSubtree rightSubtree, rightAcc) where
        (leftSubtree, leftAcc) = aux l n
        (rightSubtree, rightAcc) = aux r leftAcc
    
test = let t = Branch (Leaf 'a') (Leaf 'b')
 in label (Branch t t)
