import System.Random

type Board = [Int]

-- util for generating random numbers

randomInts :: Int -> (Int, Int) -> Int -> [Int]
randomInts n (lo, hi) zarodek = take n (randomRs (lo, hi) (mkStdGen zarodek))

-- end of util for generating random numbers

-- util for board printing

printBoard :: Board -> IO()
printBoard b = printAux b 1 where
    printAux [] _ = putStrLn ""
    printAux (x:xs) n = do
        putStr (show n)
        putStr ". "
        putStrLn (printRow x)
        printAux xs (n+1)

printRow :: Int -> String
printRow 0 = ""
printRow n = "*" ++ printRow (n-1)

-- end of util for board printing

initialize :: Int -> Board
initialize n = randomInts n (1, n) 9223372036854775807


nim :: IO()
nim = do
    putStr "Podaj liczbe wierszy: "
    numOfRows <- getLine
    let gameBoard = initialize (read numOfRows)
    play gameBoard

play :: Board -> IO()
play board = do
    playerMove board


playerMove :: Board -> IO()
playerMove board = do
    let finished = isGameFinished board
    if finished
        then putStrLn "Koniec gry! Wygral komputer"
        else do
            putStrLn ""
            printBoard board
            putStr "Podaj wiersz: "
            row <- getLine
            let isRowOk = isRowOK board (read row)
            if isRowOk
                then do
                    putStr "Podaj liczbe kamieni: "
                    num <- getLine
                    let isNumOk = isNumOK board (read num)
                    if isNumOk
                        then computerMove (deleteFrom board (read row) (read num))
                        else do
                            putStrLn "Liczba kamieni do usuniecia musi byc wieksza od zera! Popraw wybor"
                            playerMove board
                else do
                    putStrLn "Podaj poprawny nr wiersza!"
                    playerMove board

computerMove :: Board -> IO()
computerMove board = do
    let finished = isGameFinished board
    if finished
        then putStrLn "Gratulacje, wygrales!"
        else do
            putStrLn ""
            printBoard board
            g <- newStdGen
            s <- newStdGen
            let possibleRows = availableRowsIn board
            let randomRow = (possibleRows!!((head (take 1 (randomRs (1, (length possibleRows)) g ::[Int])))-1))
            let randomNum = (head (take 1 (randomRs (1, board!!(randomRow-1)) s :: [Int])))
            putStrLn ("Komputer usunal " ++ (show randomNum) ++ " kamienie z " ++ (show randomRow) ++ " rzedu.")
            playerMove (deleteFrom board randomRow randomNum)

-- util to remove from board

isNumOK :: Board -> Int -> Bool
isNumOK board num =
    if num > 0 then True else False

isRowOK :: Board -> Int -> Bool
isRowOK board row = 
    if (elem row (availableRowsIn board))
        then True
        else False

availableRowsIn :: Board -> [Int]
availableRowsIn board = aux board 1 [] where
    aux [] _ acc = acc
    aux (x:xs) n acc = 
        if x /= 0 
            then aux xs (n+1) (n:acc)
            else aux xs (n+1) acc

deleteFrom :: Board -> Int -> Int -> Board
deleteFrom board row num = aux board 1 [] where
    aux [] _ acc = reverse acc
    aux (x:xs) n acc = 
        if row == n
            then if (x - num) < 0
                then aux xs (n+1) (0:acc)
                else aux xs (n+1) (x-num:acc)
            else aux xs (n+1) (x:acc)

-- end of util to remove 

isGameFinished :: Board -> Bool
isGameFinished [] = True
isGameFinished (x:xs) = (x == 0) && isGameFinished xs


