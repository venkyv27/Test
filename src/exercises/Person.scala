package exercises

class Person {
  var name = ""
}

object Person{
  def apply(name:String) : Person = {
    var p = new Person
    p.name = name
    p
  }
}

object TestPerson extends App{
  val p1 = Person("Venkat")
  println(p1.name)
}