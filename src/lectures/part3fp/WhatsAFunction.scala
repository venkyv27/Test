package lectures.part3fp

object WhatsAFunction extends App {
  //Use functions as first class elements. However we come from OOO world where everything is instance of classes.
  //

 val doubler = new MyFunction[Int, Int] { // The first param is the input, the second Int here is the return type
   override def apply(element : Int) : Int = element * 2
 }
  println(doubler(2))

  //Scala provides OOTB function types like Function1, 2 and so . Each of these func type number is the number of params it can take.
  // For example, Function 10, takes in 10 inputs and returns one output, hence 11 arguments.

 /* The below code is the same as this one below
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(element: String): Int = element.toInt
  }*/

  val stringToIntConverter = new ((String) => Int) {
    override def apply(element: String): Int = element.toInt
  }

  println(stringToIntConverter("7"))


  val adder = new ((Int, Int) => Int) {
    override def apply (a: Int, b:Int) : Int = a + b
  }
  /*This is the same as above
  val adder = new Function2[Int, Int, Int] {
    override def apply (a: Int, b:Int) : Int = a + b
  }
   */

  //A function that takes 2 strings and concatenates them
  val concatenate = new Function2[String, String, String] {
    override def apply (a : String, b: String) : String = a + b
  }
  println(concatenate("Hello", "World"))

 val concatenate2 : (String, String) => String = (a, b) => a + b
  println(concatenate2("Hello", "Scala"))

  /*val superAdder = new Function1[Int, Function1[Int, Int]]{
    override def apply(element : Int) : Function1[Int, Int] = new Function1[Int, Int]{
      println("element is " + element)
      override def apply (x : Int) : Int = {
        println("X is " + x)
        x + element
      }
    }
  }*/
  val specialAdder1 = (x : Int) => (y : Int) => x + y // this one line is the same as verbose code below
  /*
  specialAdder1 takes in a function with input x, returns a function with input y, and then returns x + y
   */

  /*
  val superAdder : Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
  override def apply(x:Int) : Function1[Int, Int] = new Function1[Int, Int]{
  override def apply (y:Int) : Int = x + y
}
}
   */

  val superAdder : Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x : Int) : Function1[Int, Int] = new Function1[Int, Int]{
      println("element is " + x)
      override def apply (y : Int) : Int = {
        println("X is " + x)
        x + y
      }
    }
  }

 /* def concatenator : (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }*/


  val adder3 = superAdder(3)(4) //curried function
  val adder4 = specialAdder1(4) (5)
  println (adder3)
  println(adder4)

}

//ALl scala functions are objects

//As an example, we have a basic class and a method which does something.
/*class Action{
  def execute(element:Int) : String = ???
}*/
//this is at the most an object oriented language can do
trait MyFunction[A,B]{
  def apply(element:A) : B
}

//
