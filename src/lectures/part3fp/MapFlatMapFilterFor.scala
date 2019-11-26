package lectures.part3fp

object MapFlatMapFilterFor extends App {
  val list = List(1,2,3) // implicitly calls the apply method
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0)) // keep only even numbers

  //flatmap
  val toPair = (x:Int) => List(x, x+1)
  println(list.flatMap(toPair))

  //Exercise - print all possible combinations between 2 lists
  val numbers = List(1,2,3,4)
  val characters = List("a", "b", "c", "d") // we need a1, a2, a3...d3, d4 printed
  val colors = List("black", "white")

  //val combinations = numbers.flatMap(n => characters.map(c => "" + c + n ))
  val combinations = numbers.flatMap(n=>characters.flatMap(c => colors.map(color => "" + c + n + color)))
  println(combinations)

  //for comprehensions - same as above flatmap chaining
  val forCombinations = for{
    n <- numbers if n % 2 == 0 // an "if-guard" - filter out only even numbers with this statement
    c <- characters
    color <- colors
  } yield "" + c + n + color
  println(forCombinations)
}
