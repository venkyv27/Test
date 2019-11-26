package lectures.part1basics

object StringOps extends App {

  val aNumberString : String = "45"

  val aNumber = aNumberString.toInt;

  println(aNumber)

  //s-interpolators

  val name = "David"
  val greeting = s"Hello my name is $name and I am $aNumber years old"
  println(greeting)

  //f-interpolators for floats

  val speed = 300f
  val myth = f"I can run at $speed%2.5f miles per hour"
  println(myth)

  //raw interpolators
  val escaped = "This is a \n newline"
  println(raw"$escaped")


}
