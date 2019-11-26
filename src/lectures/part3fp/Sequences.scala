package lectures.part3fp

object Sequences extends App{
  //Seq
  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // extracts item in index 2, which is 3 in this case
  println(aSequence ++ Seq(5,6,7)) // appends 5,6,7 to this current sequence
  /*
  aSequence.sorted returns a sorted set of sequence
  //Ranges
  val aRange : Seq[Int] = 1 to 10
  aRange.
   */

  //Range
  val aRange : Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println(x)) // we can define a range 1 to 10 like this. This prints using a lambda

  //List
  val aList = List(1,2,3)
  val prepended = 42 :: aList // the :: syntax is just to prepend a 42 to the existing list, OR 42 +: aList
  val appended = aList :+ 89 // appends 89 to the list

  //Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int] (3) // creating an array with 3 element size without explicitly adding anything in it yet
  threeElements.foreach(println) // initializes 0 in all 3 indexes and prints 0 0 0
  //for ints default is 0, for string is null and boolean is false

  //mutation
  numbers(2) = 0 // replacing 3 with a 0

  //arrays and sequences
  val numbersSeq : Seq[Int] = numbers // implicit conversion of arrays to Sequences resulting in a wrappedAraay

  //Vectors
  val vector : Vector[Int] = Vector (1,2,3)

  //vectors vs lists



}
