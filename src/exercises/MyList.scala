package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] { // making this list generic now

  /*
  Will be coding up a linked list with
  method head that returns first element of the list : Int
  tail - remainder of the list : MyList
  isEmpty - returns boolean
  add(int) : returns a new list with element added
  override toString() which returns string rep of list

   */
  //Don't put abstract members inside abstract classes. For example abstract def head: Int won't work, unless class is not abstract
  //def head : Int // return head as an integer
  def head : A
  //def tail : MyList // return rest of the list other than head
  def tail : MyList[A]
  //def add(element: Int) : MyList
  def add[B >: A](element : B) : MyList[B]
  def isEmpty : Boolean
  def printElements : String
//We only define toStrin() in the abstract class, because by default it gets delegated to printElements of subclasses
  override def toString() : String = "[" + printElements + "]"// overriding here because this overrides the base scala toString() method
  //def map[B] (transformer: MyTransformer[A, B]) : MyList[B]
  //def flatMap[B](transformer: MyTransformer[A, MyList[B]]) : MyList[B]
  //def filter(predicate: MyPredicate[A]) : MyList[A]
}

//First an empty object- I want a singleton of this which is why this is not a class
/*object Empty extends MyList{
  override def head() = throw new NoSuchElementException()
  override def tail() : MyList = throw new NoSuchElementException()
  override def add(element : Int) = new SomeList(element, Empty)
  override def isEmpty: Boolean = true
  override def toString : String = this.printElements
  override def printElements : String = "" // Note we do not implement toString() because it gets delegated automatically to printElements
} */

/*
  Because we now use generics, MyList --> MyList[Nothing], which means it can take anything like String, Int or any other type,
  and return a "Nothing".
 */
object Empty extends MyList[Nothing]{
  override def head() = throw new NoSuchElementException()
  override def tail() : MyList[Nothing] = throw new NoSuchElementException()
  override def add[B>: Nothing](element : B) : MyList[B] = new SomeList(element, Empty)
  override def isEmpty: Boolean = true
  override def toString : String = this.printElements
  override def printElements : String = "" // Note we do not implement toString() because it gets delegated automatically to printElements
  //def map[B] (transformer: MyTransformer[Nothing, B]) : MyList[B] = Empty
  //def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]) : MyList[B] = Empty
  //def filter(predicate: MyPredicate[Nothing]) : MyList[Nothing  ] = Empty
}


class SomeList[+A] (head : A, tail : MyList[A]) extends MyList[A] {
  println("Called Now")
  override def head() : A = head
  override def tail() : MyList[A] = tail
  override def add[B >: A] (element : B) = new SomeList(element, this)
  override def isEmpty: Boolean = false

  override def toString(): String = super.toString()
  override def printElements : String = {
    if(tail.isEmpty) {
      println("tail is now empty")
      var aVar = "" + head
      println("head is now " + aVar)
      aVar
    } // if there is no tail, just print head

    else{
     var value = head + " " + tail.printElements
      println("tail elements are " + tail.printElements)
      println("In the else loop, It is now " + value)
      value
    }
   /* else{
      finalString =  head.toString + tail.head.toString
      println(tail.tail.head)
      println(tail.tail.tail)
      new SomeList(tail.tail.head, tail.tail.tail).toString()

    }*/
    //finalString + hString
   /* def filter(predicate: MyPredicate[A]) : MyList[A] = {
      if (predicate.test(head)) new SomeList[]()
    }*/
  }
}

//Section 2.20 - object oriented exercises
trait MyPredicate[-T] { // Takes in a generic of type T
  def test(element : T) : Boolean
}

trait MyTransformer[-A,B] {//takes in a generic of type A, B, and transforms A --> B
  def transform(element : A) : B
}

object test extends App{
  //println("Just Testing")
  val aList = new SomeList(1, new SomeList(2, new SomeList(3, Empty)))

  //println(aList.head())
  //println(aList.tail().head)
  println(aList.toString())

}
