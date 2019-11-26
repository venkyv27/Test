class Stack[A] { // A stack class that takes argument of type A which is a generic

  private var elements : List[A] = Nil
  def push(x : A) : Unit = {elements = x :: elements} // this method reassigns the list to a new list created by prepending x to it
  def peek() : A = elements.head
  /*
   Call peek() which returns the head element
   then reassign elements to elements.tal
   return head element
   */
  def pop() : A = {
    val currentTop = peek()
    elements = elements.tail
    currentTop

  }


}
