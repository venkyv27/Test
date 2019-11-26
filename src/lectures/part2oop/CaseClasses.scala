package lectures.part2oop

object CaseClasses extends App{

  case class Person (name:String, age : Int)
  //WHy case classes? They help with a lot of boilerplate code.
  //1. All class parameters are fields

  val jim = new Person("Jim", 34)
  println(jim.age) // this call of jim.age is possible only because class Person is a case class

  //2. Sensible toString
  println(jim.toString) // If Person were not a case class, then this toString will print cryptic class stuff

  //3. equals and hashcode already implemented
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // because in case class equals is overridden, this will work

  //4. Case classes have handy copy methods
  val jim3 = jim.copy()//a new instance of case class created.
  val jim4 = jim.copy(age = 45) // This will work too

  //5. Case classes have companion objects
  val thePerson = Person // auto creation of companion objects
  val mary = Person("Mary", 33 )  // Not calling new here, because they have companion objects OOTB

  //6. CCs are serializable, eg. Akka

  //7. CCs have extractor patterns - which is used in pattern matching

  case object UnitedKingdom {
    def name : String  = "The UK"
  }




}
