package exercises

//Exercise - video #40 (Scala - Rock the JVM). Implement a collection called Maybe[+T] with at most one element
abstract class Maybe [+T] {
  def map[B] (f : T => B) : Maybe[B]
  def flatMap[B] (f : T => Maybe[B]) : Maybe[B]
  def filter(p : T => Boolean) : Maybe [T]
}

case object MaybeNot extends Maybe [Nothing]{
  override def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  override def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot


}

case class Just[+T] (value : T) extends Maybe[T]{
  def map[B] (f : T => B) : Maybe[B] = Just(f(value))
  def flatMap[B] (f : T => Maybe[B]) : Maybe[B] = f(value)
  def filter(p : T => Boolean) : Maybe [T]  =
    if (p(value)) this
    else MaybeNot
}

object MaybeTest extends App{
  //Case class Just just takes in a generic, so in this case we pass in an integer
  val just3 = Just(3)
  //call Just.map and pass in a lambda
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x %2 == 0)))
}