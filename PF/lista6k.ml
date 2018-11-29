type punkt = {wx:float; mutable wy:float};;

let p = {wx=1.0;wy=4.0};;

p.wy <- 10.0;;

p;;


let v = [| 13; 14; 15 |];;


v.(2);;

v.(1) <- 42;;

let vec = Array.init 3 (fun i -> Array.make 3 0);;

vec;;

for i = 0 to 11 do print_int i; print_string " " done;
print_newline();;

(* listy cykliczne *)

type 'a lnode = {item: 'a; mutable next: 'a lnode};;

let mkcl e =
  let rec x = {item=e; next=x}
  in x;;


let insert_head e l =
  let x = {item=e; next=l.next}
  in l.next <- x; l;;

let insert_tail e l =
  let x = {item=e; next=l.next}
  in l.next <- x; x;;

let first ln = (ln.next).item;;

let last ln = ln.item;;

let elim_head l = l.next <- (l.next).next; l;;

let ex =
  let l = mkcl 1 in List.fold_right insert_tail [5;4;3;2] l;;


(* wejscie/wyjscie *)

let zgadnij = function () ->
                        let randGenerated = Random.int 100;
                                            let notFinished = true;
                                      while notFinished do
                                        let guess = read_int();
                                                    if guess = randGenerated
                                                    then notFinished = false; print_string "Gratulacje!"
                                                    else if guess > randGenerated
                                                    then print_string "Za duzo"
                                                    else print_string "Za malo"
                                      done
;;



                                        
                                                           
                    
