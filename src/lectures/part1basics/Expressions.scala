package lectures.part1basics

object Expressions extends App {

  val x = 1+ 2
  println (x)


  val aCondition = true
  val aConditionedVal = if(aCondition) 4 else 3 // if expression. Expressions are evaluated
  println(aConditionedVal)

  //everything in scala is an expression, even reassigning a variable

  //when scala return type is Unit, it means void

  //code blocks
  val aCodeBlock = {
      //everything declared within code block is visible only inside
    val y = 2
    val z = y + 1
    if(z>2) "hello" else "bye"
  }
  println(aCodeBlock)


}
