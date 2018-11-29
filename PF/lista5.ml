type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let lhd = function
    LNil -> failwith "lhd"
  | LCons(x, _) -> x;;

let ltl = function
    LNil -> failwith "ltl"
  | LCons(_, xf) -> xf();;

let rec lfrom k = LCons(k, fun() -> lfrom (k+1));;

let rec ltake = function
    (_, LNil) -> []
  | (0, _) -> []
  | (n, LCons(x, xf)) -> x::ltake(n-1, xf());;

let llExample = LCons(1, fun() -> LCons(2, fun() -> LCons(3, fun() -> LCons(4, fun() -> LNil))));;

let rec lrepeatKTimes k xs =
  let rec aux = function
      (LCons(x, xf), i, 0) -> aux(xf(), i+1, k)
    | (LCons(x, xf) as xl, i, r) -> LCons(x, fun() -> aux(xl, i, (r-1)))
    | (LNil, _, _) -> LNil
  in aux(xs, 0, k);;

(* zadanie 2 *)

let rec lrepeat f xs =
  let rec aux = function
      (LCons(x, xf), i, 0) -> aux(xf(), i+1, (f (i + 1)))
    | (LCons(x, xf) as xl, i, r) -> LCons(x, fun() -> aux(xl, i, (r - 1)))
    | (LNil, _, _) -> LNil
  in aux(xs, 0, (f 0));;

let llExample = LCons(9, fun() -> LCons(8, fun() -> LCons(7, fun() -> LNil)));;


ltake(30, lrepeat (fun x -> x*2 + 1) (lfrom 1));;

ltake(30, lrepeat (fun x -> x+2) (lfrom 10));;

ltake(30, lrepeat (fun x -> x*2 + 1) LNil);;

ltake(30, lrepeat (fun x -> x+2) llExample);;

(* zadanie 3 *)                                        

let sublist xs ll =
  let rec iter = function    
      (_, LNil, _) -> LNil
    | ([], ll, _) -> ll
    | (h::t, LCons(x, xf), i) -> if h = i
                                 then iter(t, xf(), i+1)
                                 else LCons(x, function() -> iter(h::t, xf(), i+1))
  in iter(List.sort compare xs, ll, 0);;


ltake(10, lfrom 10);;                                   
ltake(10, sublist [1;4;7;2] (lfrom 10));;

ltake(10, sublist [] (lfrom 10));;

ltake(10, sublist [9; 8; 1; 0] (lfrom 1));;


(* zadanie 4 *)

type 'a lBT = LEmpty | LNode of 'a * (unit -> 'a lBT) * (unit -> 'a lBT);;

let lBTex = LNode(4, (function() -> LEmpty), (function() -> LEmpty));;


let rec toLBST xs =
  let rec ins2LBST = function
      (k, LNode(x, l, r)) -> if k < x then LNode(x, (fun() -> ins2LBST(k, l())), r)
                                 else if k > x then LNode(x, l, (fun() -> ins2LBST(k, r())))
                                 else failwith "duplicate"
    | (k, LEmpty) -> LNode(k, (fun() -> LEmpty), (fun() -> LEmpty))
  in match xs with
       h::t -> ins2LBST(h, toLBST t)
     | [] -> LEmpty;;


toLBST [4];;


let inorder lbt =
  let rec aux = function
      (LEmpty, xs) -> xs
    | (LNode(x, l, r), xs) -> aux(l(), x::aux(r(), xs))
  in aux(lbt, []);;


inorder (toLBST [4;5;6;7;8]);;

      
