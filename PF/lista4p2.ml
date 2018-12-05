(* Igor Malgrab *)

(* zadanie 2 *)

type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let foldBT = fun f acc_neutral t ->
  let rec foldt = fun acc ->
    match acc with
      (Empty, ac) -> ac
     |(Node(value,left,right),ac) ->
       f value ((foldt (left, acc_neutral)), (foldt (right,acc_neutral)))
  in
  foldt (t, acc_neutral);;


(* zadanie 3 *)

(* a) *)
 
let sumBTfold = function t ->
                  foldBT (fun node_value (left_fold, right_fold) -> node_value + left_fold + right_fold) 0 t;;
 
sumBTfold t;;
sumBTfold tt;;
 
(* b) *)
 
let inorderBTfold = fun t->
  foldBT (fun node_value (left_fold, right_fold) ->
      left_fold@node_value::right_fold
    ) [] t;;
 
inorderBTfold t;;
inorderBTfold tt;;

(* zadanie 4 *)

let rec mapBT = fun f t ->
  foldBT (fun node_value (left_fold, right_fold) ->
      Node((f node_value), left_fold, right_fold)) Empty t;;


(* zadanie 5 *)

type 'a tree = L of 'a | N of 'a tree * 'a tree;;

let test = N(N(L 1,L 2), N(L 3,L 4));;

let store t =
  let rec aux = function
      (L(x), xs) -> Some x::xs
    | (N(l, r), xs) -> aux(l, aux(r, None::xs))
  in aux (t, []);;

let drzewo1 = N(L(1), N(L(2), L(3)));;

store drzewo1;;

store test;;

(* zadanie 6 *)

exception Load;;

let rec load = fun ls ->
  let rec aux = fun stack ls ->
    match (stack,ls) with
      (stack,[])-> List.hd stack
     |(stack, ((Some x)::ys) ) ->
       aux ((L x)::stack) ys
     |((right::left::stack) , (None::ys)) ->
       aux ((N(left,right))::stack) ys
     |([],None::_) -> raise Load
     |(_::[], None::_) -> raise Load
  in
  aux [] ls;;

load [Some 1; Some 2; None; Some 3; Some 4; None; None];;
