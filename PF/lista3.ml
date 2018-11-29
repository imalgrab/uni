(* Igor Malgrab *)
(* zadanie 5 *)

type 'a binTree = Node of 'a * 'a binTree * 'a binTree | Empty;;
type 'a set = { bST: 'a binTree; lessThan: 'a -> 'a -> bool };;

let drzewo = Node("e",
                  Node("a",
                       Empty,
                       Node("b",
                            Empty,
                            Empty)),
                  Node("f",
                       Empty,
                       Node("g",
                            Empty,
                            Empty)));;

let drzewo1 = Node("e",
                  Node("a",
                       Empty,
                       Node("b",
                            Empty,
                            Empty)),
                  Node("f",
                       Empty,
                       Empty));;

let drzewo2 = Node("e",
                  Node("a",
                       Empty,
                       Node("b", Empty, Empty)),
                  Node("f",
                       Empty,
                       Node("h",
                            Node("g", Empty, Empty),
                            Node("i", Empty, Empty))));;
                                 

let zbior = { bST = drzewo; lessThan = (<) };;

let zbior1 = { bST = drzewo1; lessThan = (<) };;

let emptySet ord = { bST = Empty; lessThan = ord };;

let isSetEmpty s = if s.bST = Empty then true else false;;

let contains k s =
  let ord = s.lessThan in
  let rec aux tr =
    match tr with
      Empty -> false
    | Node(v, l, r) -> if k = v then true
                       else if ord k v then aux l
                       else aux r
  in aux (s.bST);;                               

let include2set k s =
  let tree = s.bST and ord = s.lessThan in
  let rec insert2BT = function
    (k, Node(v, l, r)) -> if ord k v then Node(v, insert2BT(k, l), r) else
                            if ord v k then Node(v, l, insert2BT(k, r))
                            else failwith "duplicated key"
    | (k, Empty) -> Node(k, Empty, Empty)
  in
  if contains k s then s
  else { bST = insert2BT(k, tree); lessThan = ord };;

let descendingElements s =
  let tree = s.bST in
  let rec aux = function
      (Empty, xs) -> xs
    | (Node(v, l, r), xs) -> aux(r, v::aux(l, xs))
  in aux (tree, []);;

let maxElem s =
  let tree = s.bST in
  let rec aux = function
      Empty -> None
    | Node(v, l, r) -> if r = Empty then Some v
                       else (aux r)
  in aux tree;;

let setSize s =
  let tree = s.bST in
  let rec size t =
    match t with
      Empty -> 0
    | Node(v, l, r) -> 1 + (size l) + (size r)
  in size tree;;

(* union, filter, remove *)

let rec minVal t =
  match t with
    Node(v, l, r) -> if l = Empty then v
                     else minVal l
  | Empty -> failwith "Empty tree";;

let remove e s =
  let tree = s.bST in
  let rec rem e bt =
    match bt with
      Empty -> Empty
    | Node(v, l, r) -> if e < v then Node(v, rem e l, r)
                       else if e > v then Node(v, l, rem e r)
                       else if l = Empty && r = Empty then Empty
                       else if l = Empty then r
                       else if r = Empty then l
                       else let nVal = minVal r in
                            Node(nVal, l, rem nVal r)
  in if contains e s then { bST = rem e tree; lessThan = s.lessThan }
     else s;;

let filterSet pred s =
  let tree = s.bST in
  let rec rem e bt =
    match bt with
      Empty -> Empty
    | Node(v, l, r) -> if e < v then Node(v, rem e l, r)
                       else if e > v then Node(v, l, rem e r)
                       else if l = Empty && r = Empty then Empty
                       else if l = Empty then r
                       else if r = Empty then l
                       else let nVal = minVal r in
                            Node(nVal, l, rem nVal r) in
  let rec aux t =
    match t with
      Empty -> Empty
    | Node(v, l, r) -> if pred v then Node(v, aux l, aux r)
                       else aux (rem v t)
  in { bST = aux tree; lessThan = s.lessThan };;

let unionSet s1 s2 =
  let ls = descendingElements s1 and ord = s2.lessThan in
  let rec insert2BT = function
    (k, Node(v, l, r)) -> if ord k v then Node(v, insert2BT(k, l), r) else
                            if ord v k then Node(v, l, insert2BT(k, r))
                            else failwith "duplicated key"
    | (k, Empty) -> Node(k, Empty, Empty)
  in
  let rec aux xs bt =
    match xs with
      [] -> bt
    | h::t -> if contains h s2 then aux t bt
              else aux t (insert2BT(h, bt))
  in { bST = aux ls s2.bST; lessThan = ord };;



(* test *)



let testSet() =   let set0 = emptySet (<)   in let set1 = include2set "e" set0      in let set2 = include2set "a" set1         in let set3 = include2set "b" set2            in let set4 = include2set "f" set3               in let set5 = include2set "g" set3                  in                  begin                     print_endline "isSetEmpty: on set0";                                 assert(isSetEmpty set0);                     print_endline "isSetEmpty: on set4";                      assert(not (isSetEmpty set4));                     print_endline "setSize: on set0";                     assert(setSize set0 = 0);                     print_endline "setSize: on set4";                     assert(setSize set4 = 4);                     print_endline "contains: on set4";                     assert(contains "b" set4);                     print_endline "maxElem: on set4";                     assert(maxElem set4 = Some "f");                     print_endline "descendingElements: on set4";                     assert(descendingElements set4 = ["f"; "e"; "b"; "a"]);                     print_endline "filterSet: on set4";                     assert(descendingElements(filterSet ((<) "b") set4) = ["f"; "e"]);                     print_endline ("unionSet: on set4 and set5");                     assert(descendingElements(unionSet set4 set5) = ["g"; "f"; "e"; "b"; "a"]);                     print_endline ("unionSet: on set0 and set5");                     assert(descendingElements(unionSet set0 set5) = ["g"; "e"; "b"; "a"]);                     print_endline ("remove: b from set4");                                    assert(descendingElements(remove "b" set4) = ["f"; "e"; "a"])                  end ;; 
 
testSet();; 
