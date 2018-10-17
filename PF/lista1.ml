(* Igor Malgrab *)
(* lista 1 *)

(* zad 1 *)

let f1 (x, y) = (2 * x, 3 * y);;

let f2 (x, y) = if x -. y > 0.0 then true else false;;

let rec f3 (xs, x) = if x = 0 then [] else xs @ f3(xs, x-1);;

(* zad 2 *)

let ends xs = (List.hd xs, List.hd (List.rev xs));;

(* zad 3 *)

let rec isSorted xs =
  if xs = [] then true
  else if List.tl xs = [] then true
  else if List.hd xs <= List.hd (List.tl xs) then isSorted (List.tl xs)
  else false;;

isSorted[];;

isSorted[1];;

isSorted[1;3;3;5;6;7];;

isSorted[1;3;3;5;6;7;2];;

isSorted[4;3;2;1];;

(* zad 4 *)

let powers (a, n) =
  let rec aux (i, x, acc) =
    if i > n then List.rev acc
    else aux (i+1, x*a, x :: acc) in
  aux (0, 1, []);;

powers(2, 10);;

(* zad 5 *)

let split (xs, e) =
  let rec aux (xs, sml, grt) =
    if xs = [] then (List.rev sml, List.rev grt)
    else if List.hd xs <= e then aux (List.tl xs, List.hd xs :: sml, grt)
    else aux (List.tl xs, sml, List.hd xs :: grt)
  in aux (xs, [], []);;

split(['a';'s';'h';'g'], 'g');;

split(['b';'c';'a';'p';'l';'m';'n'], 'm');;

(* zad 6 *)

let segments (xs, n) =
  let rec aux (xs, ys, i, acc) =
    if xs = [] then List.rev (ys :: acc)
    else if i = 0 then aux(xs, [], n, List.rev ys :: acc)
    else aux(List.tl xs, List.hd xs :: ys, i-1, acc)    
  in aux(xs, [], n, []);;

                  
segments([1;2;3;4;5;6;7;8;9], 2);;

(* zad 7 *)

let swap (xs, a) =
  let rec aux (xs, a, ys) =
    if xs = [] && ys = [] then []
    else if xs = [] then xs@List.rev ys
    else if a = 0 then xs@List.rev ys
    else aux(List.tl xs, a-1, List.hd xs :: ys)
  in aux(xs, a, []);;

swap(["a";"b";"5";"6"], 2);;
swap(["a";"b";"5";"6"], 4);;
