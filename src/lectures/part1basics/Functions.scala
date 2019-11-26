package lectures.part1basics

object Functions extends App {
  def aFunction(a : String, b : Int) : String = {
    a + "" + b
  }

  println(aFunction ("Venkat", 27))

  def aParameterlessFunction() : Int = 32

  //println (aParameterlessFunction())
  //println(aParameterlessFunction)

  def aRepeatedFunction(aString : String, b : Int) : String = {
    if(b ==1){
      aString
    }
    else{
      aString + aRepeatedFunction(aString, b-1)//when you need loops, use recursion in a functional programming like scala

    }
  }
println(aRepeatedFunction("Hello", 5 ))


  //fib (n) = fib (n-1) + fib (n-2)
  def fibonacci (n : Int) : Int = {
    if(n == 0) 0
    else if (n <= 2) 1
    else{
      fibonacci(n-1) + fibonacci(n-2)
    }
  }
  println(fibonacci(9))

}
