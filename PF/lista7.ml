module type QUEUE_FUN =
sig
  (* Module [QueueFun]: first-in first-out queues *)

  (* This module implements queues (FIFOs)in a functional way. *)

  type 'a t
        (* The type of queues containing elements of type ['a]. *)
  exception Empty of string
        (* Raised when [first] is applied to an empty queue. *)
  val create: unit -> 'a t
        (* Return a new queue, initially empty. *)
  val enqueue: 'a * 'a t -> 'a t
        (* [enqueue x q] adds the element [x] at the end of queue [q]. *)
  val dequeue: 'a t -> 'a t
        (* [dequeue q] removes the first element in queue [q] *)        
  val first: 'a t -> 'a
        (* [first q] returns the first element in queue [q] without removing  
           it from the queue, or raises [Empty] if the queue is empty.*) 
  val isEmpty: 'a t -> bool
        (* [isEmpty q] returns [true] if queue [q] is empty, 
           otherwise returns [false]. *)
end;;

(* Igor Malgrab *)
(* zadanie 1 *)
(* a *)

module Queue_A : QUEUE_FUN =
  struct
    type 'a t = EmptyQueue | Enqueue of 'a * 'a t
                                      
    exception Empty of string
                     
    let create() = EmptyQueue
                 
    let rec enqueue = function
        (x, EmptyQueue) -> Enqueue(x, EmptyQueue)
      | (x, Enqueue(y, q)) -> Enqueue(y, enqueue(x, q));;
                      
    let dequeue = function
        EmptyQueue -> EmptyQueue
      | Enqueue(_, q) -> q
                       
    let first = function
        EmptyQueue -> raise (Empty "module Queue: first")
      | Enqueue(x, _) -> x
                       
    let isEmpty q = q = EmptyQueue
  end;;

Queue_A.(isEmpty(enqueue(10, create())));;
Queue_A.(isEmpty(create()));;

Queue_A.(first(dequeue(enqueue(10, enqueue(20, create())))));;
Queue_A.(first(enqueue(10, dequeue(enqueue(20, create())))));;


module Queue_B : QUEUE_FUN =
  struct
    type 'a t = 'a list
    exception Empty of string
    let create() = []
    let enqueue(x, q) = q @ [x]
    let dequeue = function
        [] -> []
      | h::t -> t
    let first = function
        [] -> raise (Empty "module Queue: first")
      | h::t -> h
    let isEmpty q = q = []
  end;;


let p = Queue_B.(enqueue(10, enqueue(24, create())));;

Queue_B.first(p);;

module Queue_C : QUEUE_FUN =
  struct
    type 'a t = 'a list * 'a list
    exception Empty of string
    let create() = [], []
    let rec enqueue = function
        (y, ([], [])) -> (y::[], [])
      | (y, ([], yl)) -> enqueue(y, (List.rev yl, []))
      | (y, (xl, yl)) -> (xl, y::yl)
    let rec dequeue = function
        ([], []) -> ([], [])
      | (x::[], yl) -> (List.rev yl, [])
      | (x::xl, yl) -> (xl, yl)
      | ([], yl) -> (List.rev yl, [])
    let first = function
        (y::xl, yl) -> y
      | ([], _) -> raise (Empty "module Queue: first")
    let isEmpty q = q = ([], [])
  end;;

Queue_C.(isEmpty(enqueue(10, create())));;
Queue_C.(isEmpty(create()));;

Queue_C.(first(dequeue(enqueue(10, enqueue(20, create())))));;
Queue_C.(first(enqueue(10, dequeue(enqueue(20, create())))));;


        
        
      
                                       
                    
        
        
      
                         
      
        
          
