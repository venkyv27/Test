package exercises

object TrialExercises extends App{

  def Factorial(n : Int): Int ={

    if(n <= 0 ){
      1

    }

    else n * Factorial(n-1)


  }
  println(Factorial(5))
}
