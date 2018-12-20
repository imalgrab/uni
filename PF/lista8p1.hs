-- Igor Malgrab --

import Data.List

-- zadanie 1

lrepeat :: (Int -> Int) -> [a] ->[a]
lrepeat f xs =
  aux (xs, 0, (f 0)) where
  aux (xs, i, r) =
    case (xs, i, r) of
      (x:xf, i, 0) -> aux(xf, i+1, (f (i+1)))
      (x:xf, i, r) -> x:aux(x:xf, i, r-1)
      ([], _, _) -> []
      
-- lrepeat (\x -> x+1) [1..5]
-- lrepeat (\x -> x*2+3) [1..3]
-- lrepeat (\x -> x+2) []

-- zadanie 2

sublist :: [Int] -> [a] -> [a]
sublist xs ys =
  iter ((sort xs), ys, 0) where
  iter (xs, ys, i) =
    case (xs, ys, i) of
      (_, [], _) -> []
      ([], ys, _) -> ys
      (h1:t1, h2:t2, i) ->
        if h1 == i
        then iter(t1, t2, i+1)
        else h2:iter(h1:t1, t2, i+1)

-- sublist [0, 2, 4, 6, 8] [1..4]
-- sublist [] [1..12]
-- sublist [2, 3, 5] []


-- zadanie 3

-- a

root3 :: Double -> Double

root3 x =
  aux xi 0 where
  aux xi 0 = if x > 1
    then a/3
    else a
  aux xi i = if abs(xi*xi*xi - x) <= 1.0e-15 * abs(x)
    then xi
    else xi + (a/(aux $! xi i) - (aux $! xi i))/3

    
  


  






        
        
    


      



    
  
      

   
      

    
    
    
    
    
