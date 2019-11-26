package lectures.part1basics

import lectures.part1basics.Functions.fibonacci

import scala.annotation.tailrec

object Recursion extends App {


  def Factorial(n : Int): Int ={

    if(n <= 0 ){
      1

    }

    else {
      println("Computing factorial of " + n + " - I first need factorial of n-1 ")
      val result = n * Factorial(n - 1)//Recursion adds everything into the stack first and then starts computing after

      println("Computed factorial of " + n )
      result
    }


  }
  println(Factorial(10))//if we do this for like 5000, we run into stackoverflow error because recursive depth is too big
  //use tail recursion
  @tailrec
  def concatenateTailRec(aString:String, n: Int, accumulator:String) : String =
    if(n<=0) accumulator
    else concatenateTailRec(aString, n-1, aString + accumulator)

    println(concatenateTailRec("hello", 3, ""))



  def factorialTailRec(n : Int) : Int = {
    def factHelper(x : Int, accumulator : Int) : Int =
      if(x <= 1) accumulator
      else factHelper(x-1, x* accumulator )


    factHelper(n, 1)



  }
  println(factorialTailRec(6))

  /*def fibonacci(n : Int) : Int = {
    def fiboTailRec( x : Int, last : Int , nextToLast : Int) : Int =
      //if(x == 0) 0
    if(x >= n) last //if x which is 2 is >= n, then just return 1 which is last
    else fiboTailRec(x+1, last + nextToLast, last)

      fiboTailRec(2 , 1, 1)
  } */





}

