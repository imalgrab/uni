(* Igor Malgrab *)


(* zadanie 1 *)

  
let zgadnij() =
  begin
    print_string "Podaj liczbe od 0 do 100: ";
    let wylosowana = Random.int 101
    and proba = ref (read_int()) in
    while wylosowana <> !proba do
      if wylosowana > !proba
      then
        print_string "Moja wieksza"
      else
        print_string "Moja mniejsza";
      
      print_newline();
      proba := read_int()  
    done;
    print_string "Gratulacje!";
    print_newline ()
  end;;

(* zadanie 2 *)
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let t = Node(1, Node(2, Empty, Node(3, Empty, Empty)), Empty);;

let  printBT bt =
  let rec aux bt iter =
    let printkropki iter =
      for i = 0 to iter do
        print_string "..."
      done;
    in        
    begin
      match bt with
        Empty -> printkropki (iter - 1);
                 print_string "||";
      | Node(a, bt1, bt2) -> aux bt2 (iter+1);
                             print_newline();
                             printkropki (iter -1);
                             print_int a;
                             print_newline();
                             aux bt1 (iter+1);
    end
  in
  aux bt 0;
  print_newline();;

printBT t;;
printBT Empty;;



(* zadanie 3 *)

let sortuj_plik() =
  begin
    print_string "Podaj nazwe pliku: ";
    let filename = ref (read_line())
    and filenameOut = "result.txt" in
    let inputFile = open_in !filename in
    let numOfElements = ref (int_of_string (input_line inputFile)) in
    let elements = ref (Array.make !numOfElements 0)
    and i = ref 0 and j = ref 0 in
    while !numOfElements > 0 do
      !elements.(!i) <- int_of_string (input_line inputFile);
      i := !i + 1;
      numOfElements := !numOfElements - 1;
    done;
    close_in inputFile;
    let xs = ref (Array.to_list !elements) in
    xs := List.sort compare !xs;
    elements := Array.of_list !xs;
    let outputFile = open_out filenameOut in
    while !i > 0 do
      output_string outputFile (string_of_int !elements.(!j));
      output_string outputFile " ";
      j := !j + 1;
      i := !i - 1;
    done;
    close_out outputFile;
  end;;


    
    
    
    
