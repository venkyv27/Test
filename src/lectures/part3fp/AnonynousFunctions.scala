package lectures.part3fp

object AnonynousFunctions extends App {

  /*val doubler = new Function[Int, Int] {
    override def apply(a : Int) : Int = a * 2
  }*/
  //The equivalent of above is this
  //This is a lambda or anonymous function
  val doubler = (a: Int) => a * 2
  //Alternate way
  //val doubler : Int => Int = a => a *2 // Type inference happens here because Int=>Int tells input is int and so it output
  //val doubler = (a : Int) => a * 2 //another way of writing without type inference
  val adder = (a: Int, b: Int) => a + b
  //val adder : (Int, Int) => Int = a, b => a + b
  //no params lambda
  val justDoSomething :() => Int = () => 3

  //More syntactic sugar
  //val incrementer : Int => Int = x => x + 1
  val incrementer : Int => Int = _ + 1
  val niceAdder : (Int, Int) => Int = _ + _ //This adds the 2 integers


}
