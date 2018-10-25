(* Igor Malgrab *)

(* zad 1 *)

let fib n =
  if n = 0 then 0 else
  let rec iter (n, a, b) =
    if n = 1 then b
    else iter ((n-1), b, a+b)
  in iter (n, 0, 1);;

let rec fibrec n =
  if n = 0 then 0
  else if n = 1 then 1
  else fibrec (n-2) + fibrec (n-1);;  

fib 13;;
fibrec 13;;
fib 0;;
fibrec 0;;
fib 42;;
fibrec 42;;

(* zad 2 *)

let (<->) (a1, b1, c1) (a2, b2, c2) =
  sqrt((a1-.a2)*.(a1-.a2) +. (b1-.b2)*.(b1-.b2) +. (c1-.c2)*.(c1-.c2));;

(1.0, 1.0, 1.0) <-> (1.0, 1.0, 0.0);;

(0.0, 0.0, 0.0) <-> (0.0, 0.0, 0.0);;

(2.0, 0.0, 0.0) <-> (0.0, 0.0, 0.0);;

(* zad 3 *)

let rec (<--) xs e =
  match xs with
  | [] -> e :: xs
  | h :: t -> if e <= h then e :: (h :: t)
              else h :: (t <-- e);;


[1;3;5;5;7] <-- 2;;

(* zad 4 *)

let rec take n xs =
  match xs with
  | [] -> []
  | h :: t -> if n > 0 then h :: take (n-1) t
              else (take (n-1) t);;

take 2 [1;3;5;7;9];;
take 0 [2;4;6];;
take (-3) [1;2;99];;
take 10 [99;98;97];;

(* zad 5 *)

let rec drop n xs =
  match xs with
  | [] -> []
  | h :: t -> if n > 0 then drop (n-1) t
              else h :: t;;


drop 2 [1;2;3;5;6];;
drop (-2) [1;2;3;5;6];;
drop 8 [1;2;3;5;6];;
drop 4 [];;

(* zad 6 *)

(* let rec repeatList xs =
  match xs with
  | [] -> []
  | h :: t -> *)
