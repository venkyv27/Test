package lectures.part2oop

object Exceptions extends App {
  val sString: String = null

  //dummy method coded here
  def getInt(withException : Boolean) : Int = {
    if(withException) throw new RuntimeException
    else 400
  }

  //try-catch
  try{
    getInt(true )
  }
  catch{
    case e: RuntimeException => println("Caught a RuntimeException")
    case f : NoSuchElementException => println("NoSuchElement") // this will never get executed but just for example
    case f : NoSuchElementException => println("NoSuchElement") // this will never get executed but just for example
  }
  finally{
    //gets executed no matter what
    println("Finally")
  }

  //Exceptions.getInt(true)
  //1. causing an OOM
 // val array = Array.ofDim(Int.MaxValue) //-code to dump an OOM

  //2.Causing a StackOverflow errr
  //def infinite : Int = 1 +infinite
  //val noLimit = infinite



}
