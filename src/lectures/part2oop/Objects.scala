package lectures.part2oop

object Objects extends App {
  //Scala does not have class level functionality. No STATIC in scala.
  object Person{// this is the equivalent of static in java, have an object defined with a val field in there
    val N_EYES = 2
    def canFly() : Boolean = false // Objects can have methods, vals and vars like classes, but it takes not params
    //like classes do.

    //Now we can call Person object and call apply like Person(mary, jon) because we don't need to explicitly call apply
    def apply(mother : Person, father:Person) : Person = new Person("Bobby")
  }

  //we can also have a class named Person, but we need an instance of it to access it
  //Companions
  class Person (name : String){
    def name() : String = "Venkat"
  }
  println(Person.N_EYES)

  //On an object, we can do something like this
  println(Person.canFly())

  //Both Mary and Jon point to the same Person instance
  val mary = Person
  val jon = Person
  println(mary == jon)

  //But on a class we first need to instantiate it
  val person: Person = new Person("Mary")
  println(person.name())

  //val bobby = Person.apply(mary, jon)
  //In the



  //scala object is a singleton instance

  //Scala Application = Scala object with def main(args:Array[String] : Unit
  //Either use extends App or use def main (args:Array[String]) : Unit

}
