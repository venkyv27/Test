package lectures.part1basics

object DefaultArgs extends App {

  def factHelper(x : Int, accumulator : Int = 1) : Int =  // added default value of accumulator= 1
    if(x <= 1) accumulator
    else factHelper(x-1, x* accumulator )


  factHelper(10) // no need to send second parameter for accumulator here


}
