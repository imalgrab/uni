-- Igor Malgrab
-- zadanie 3
-- a

root3 :: Double -> Double
root3 a = if a > 1 then aux (a/3) else aux a where
    aux x =
        if abs(x*x*x - a) <= 1.0e-15 * abs(a)
            then x
            else aux $! (x + (a/(x*x) - x)/3)

-- b

root3l :: Double -> [Double]
root3l a = if a > 1 
    then iterate aux (a/3)
    else iterate aux a where
    aux x = x + (a/(x*x) - x)/3