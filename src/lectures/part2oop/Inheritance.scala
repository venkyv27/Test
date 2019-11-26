package lectures.part2oop

object Inheritance extends App {

  //Single class inheritance only just like java
  sealed class Animal{ // by sealing it I can extend Dog and Cat in this file, but not in any other file
    val creatureType = "Wild"
    def eat() = println ("nom nom")
  }

  class Cat extends Animal
  val cat = new Cat
  cat.eat()


  //constructor
  class Person(name : String, age : Int){
    def this(name : String){ //this is a constructor too
      this(name, 0)
    }// constructor with one argument only, but in turn calls the correct instance with name and age
  }
  class Adult (name : String, age : Int, idCard : String) extends Person(name, age) // need to do extends Person (name, age) passed
  //in as params
  //below will also work because there is a constructor with only one parameter
  //class Adult (name : String, age : Int, idCard : String) extends Person(name)

  //overriding
  class Dog(name:String)  extends Animal{

    override def eat(): Unit = {
      super.eat()
      println("crunch crunch")
    }
    override val creatureType = "domestic"
  }

  val dog = new Dog ("Blah")
  dog.eat()
  println(dog.creatureType)

  //type susbstitution OR Polymorphims
  val someAnimal : Animal = new Dog("K9")
  someAnimal.eat()

  //Super : shown above in def eat() method

  //preventing overrides by using keyword final, for example
  // Final on methods : final def eat() : = println("nom nom")
  // Final on class : final class Animal {

  //Seal the class - allows extending class in this file but not in other files







}
