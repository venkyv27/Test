package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42 // val x type is explicitly called out
  val k = 43
  val y : Int  = 54
  var z = 5
  println(x)
  println(z)
  z = 6
  println(z)
  //x = 2 ; vals are immutable in scala

  val aString : String = "hello"
  println(aString)

  val aBoolean : Boolean = false
  //val aChar : char = 'a'

  //variables
  var aVar : Int = 4 // they are mutable and can be reassigned


}