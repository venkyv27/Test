package lectures.part2oop

object MethodNotations extends App{
  class Person (val name : String, favoriteMovie : String){ // creating this inside the object
    def likes(movie : String) : Boolean = {
      movie == favoriteMovie
    }

    def isAlive : Boolean = true // implementation not important here
    def hangOutWith(person:Person) : String = s"${this.name} hang out with ${person.name}"
    def apply(): String = "Hello There"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // infix or operator notation, same as above.
  //methods with single parameter can use infix or operator notation

  //"operators" in scala

  val tom = new Person("Tom", "Fight Club")
  val jon = new Person("Jon", "Titanic")

  println(mary hangOutWith tom)
  println(mary hangOutWith(jon))
  println(mary.hangOutWith(jon))

  //prefix notation
  val x = -1  //-ve sign is unary operator
  val y = 1.unary_-
  println (x ==y)

  //postfix notation
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) // same as above. When a class is called like a function, that means calling apply() method




}
