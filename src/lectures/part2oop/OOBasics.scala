package lectures.part2oop

object OOBasics extends App {
  val person = new Person ("john", 45)
  println(person.age)
  person.greet("Venkat")

}
//constructor. If you don't add val age, then we cannot call
//person.age because a parameter is not a field, and only class fields can be accessed as class instance.field
// which in this case is (person.field)
class Person(name : String, val age : Int = 0){


  // default parameter value for age is 0
  val x = 2

  def greet (name : String) : Unit = println(s"${this.name} says Hello $name") // this.name is John because that's how this constructor is called

  //constructor
   // because age is default param, call constructor only with name param
  def this() = this("No Name")


}






