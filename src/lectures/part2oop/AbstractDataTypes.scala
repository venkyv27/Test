package lectures.part2oop

object AbstractDataTypes extends App {
  abstract class Animal {

    val creatureType : String
    def eat : Unit
  }

  class Dog extends Animal{
    override val creatureType : String = "K9"
    override def eat : Unit = println("nom nom")

  }

  //traits
  /*traits vs abstract classes
   - traits have no constructor params
   - multiple inheritance via traits
   - traits describe behaviors, just like the actual noun traits. Abstracts is a type of thing.
   */

  trait Carnivore {
    def eat(animal: Animal) : Unit // abstract members
    val preferredMeal : String = "Meat" // traits can have non-abstract member too
  }

  trait ColdBlooded {

  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    override def eat: Unit = println("nom nom")
    def eat (animal: Animal) : Unit = println(s"I'm a ${this.creatureType} and I eat a ${animal.creatureType}")

  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


}
