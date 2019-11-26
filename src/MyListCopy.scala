package random

import exercises.MyTransformer

abstract class MyListCopy[A] {

  def head : A
  def tail : MyListCopy[A]
  def isEmpty : Boolean
  def add[B >: A](element : B) : MyListCopy[B] // adds and returns a new list because we coded an immutable collection
  def printElements : String
  override def toString: String = "[" + printElements + "]"
 // def map[B](transformer: MyTransformer[A, B]) : MyListCopy[B]
 //Higher Order Functions are map, filter and flatmap. HOFs either take in functions are params to return other functions as result
  def map[B](transformer: A => B) : MyListCopy[B]
  //def filter(predicate : MyPredicate[A]) : MyListCopy[A]
  def filter[A](predicate : A => Boolean) : MyListCopy[A]
  def flatMap[B](transformer: MyTransformer[A, MyListCopy[B]]) : MyListCopy[B]

  /*
  HOFs
  chapter 39 (exercise) in Scala course
  Add a foreach method which take A => Unit
  Example - [1,2,3].foreach(x => println(x)) // for every element in the list print the element

   */
  def foreach(f : A => Unit) : Unit
}
// objects can extend classes, and we need this at the time of creating an instance of MyListCopy
/*case object Empty extends MyListCopy[Nothing]{
  def head : Nothing = throw new NoSuchElementException
  def tail : MyListCopy[Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  //adding returns a new instance of Cons with added element as the head
  def add(element : Int) : MyListCopy[Nothing] = new Cons(element, Empty)
  override def printElements: String = ""
  //def map[B](transformer: MyTransformer[Nothing, B]) : MyListCopy[B] = Empty
  def map[B](transformer: Nothing => B) : MyListCopy[B] = Empty
  //def filter(predicate : MyPredicate[Nothing]) : MyListCopy[Nothing] = Empty
  def filter(predicate : Nothing => Boolean) : MyListCopy[Nothing] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyListCopy[B]]) : MyListCopy[B] = Empty
  def foreach(f : Nothing => Unit) : Unit = () // This () is simply returning the unit value and doing nothing
}

case class Cons[+A](h : A, t : MyListCopy[A]) extends MyListCopy {
  println("Entering Cons and head is " + h)
  if( t == Empty) println ("MyListCopy is Empty")
  def head : A = h
  def tail : MyListCopy[A]= t
  def isEmpty : Boolean = false
  //Calling add simply creates a new Cons instance with element as head and current instance as tail
  //So basically an element is added to the head always, and also it only creates an instance with head and tail, no real appending happens
  //which is pretty cool if you think about it

  def add[B >: A](element : B) : MyListCopy[B] = new Cons(element, this)

  override def printElements: String = {
    println(("Entering printElements in Cons"))
    println (t.hashCode())
    if(t.isEmpty){
      println("tail is empty")
      "" + h
    }
    else {
      println("head is now " + h + "and the hashcode is " + t.hashCode())
      h + "" + t.printElements
    }
  }

 // def filter(predicate : MyPredicate[A]) : MyListCopy[A] =
 def filter(predicate : A => Boolean) : MyListCopy[A] =

 /*
 if predicate.test on head passes, then create a new Cons instance with head and recursive t.filter
 otherwise simply filter out head and apply filter on the tail itself
  */
    if(predicate.apply(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)



  def map[B] (transformer:A => B) : MyListCopy[B] =
    /*
    apply transformer on head and then tail recursively
     */
    new Cons(transformer.apply(h), t.map(transformer))


  //Add a foreach method which take A => Unit
  //Example - [1,2,3].foreach(x => println(x)) // for every element in the list print the element
  def foreach(f : A => Unit) : Unit ={
    f(h)
    t.foreach(f)
  }


}

//Change the MyPredicate and MyTransformer to be of function types, which means there is no need to have them
//as traits here, but directly do things like A => B in the implementation itself
/*trait MyPredicate[-T]{ // an implementation of MyListCopy will extend/with this predicate
//MyPredicate is a function type with T => Booleam
  def test[T] (element : T) : Boolean
}

trait MyTransformer[-A, B]{//func type with A => B
  def transform(element : A) : B
}*/

/*
 Write a function that takes an int as parameter, and returns a function that takes an int and returns an int
 --> Function1[Int, Function1[Int, Int]]
 */


/*
Video #40 - for comprehensions
Question > Does MyListCopy support for comprehensions?
Ans > For for-comprehensions to work, the following need to be true
  - map (f : A=> B) : MyList[B]
  - filter (predicate : A => Boolean) : MyList[A]
  - flatMap(f : A => MyList[B]) : MyList[B]
Since MyListCopy class has all of the above methods with the right signatures, yes, it can use for comprehension.
 */



object ListTest extends App{
  //val list = new Cons (1, Empty)
  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4,Empty))))
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, new Cons(4,Empty))))
  val listOfStrings = new Cons("A", new Cons("B", new Cons("B", new Cons("C",Empty))))
  //println(list.head())
  //println(list.tail.head())
  //println(list.tail.add(4).head())
  //println(list.toString)


  //using anonymous class implementation
  /*println(list.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).toString)
  println(list.filter(new MyPredicate[Int] {
    override def test(element: Int): Int = element % 2 == 0
  }).toString)*/

  //The above 2 anonymnous classes can be replaced as follows
  println(list.map(new Function1[Int, Int] {
    /* Function1 which is built in to scala, takes an int as param and returns an int as output
    */

    override def apply(element: Int): Int = element * 2
  }).toString)
  println(list.filter(new Function1[Int, Boolean] {
    override def apply(element: Int): Boolean = element % 2 == 0
  }).toString)

  list.foreach(x => println(x))

  //for comprehensions
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield "" + n + "-" + string

  println(combinations)

*/

//}
