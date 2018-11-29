(* Igor Malgrab *)

(* zadanie 2 *)

type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let rec foldBT f acc bt =
  match bt with
    Empty -> acc
  | Node(v, l, r) -> foldBT f (f v ((foldBT f acc r), acc)) l;;

(* zadanie 3 *)

let sumBTfold = function t -> foldBT (fun nval (racc, acc) -> nval + racc) 0  t;;

sumBTfold (Node(1, Empty, Node(2, Empty, Node(3, Empty, Node(4, Empty, Empty)))));;

let inorderBTfold = 0;;

(* zadanie 4 *)


(* zadanie 5 *)

type 'a tree = L of 'a | N of 'a tree * 'a tree;;

let store t =
  let rec aux = function
      (L(x), xs) -> Some x::xs
    | (N(l, r), xs) -> aux(l, aux(r, None::xs))
  in aux (t, []);;

let drzewo1 = N(L(1), N(L(2), L(3)));;

store drzewo1;;

store Empty;;
