package exercises

import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy

class Covariance {

}

abstract class Animal{
  def name : String
}

case class Cat(name : String) extends Animal
case class Dog(name : String) extends Animal

object CovarianceTest extends App{
  def printAnimalNames(animals : List[Animal]) : Unit = {
    animals.foreach{ animal => println(animal.name)

      }
   }
  val cats = List(Cat("WHiskers"), Cat("Boots"))
  val dogs = List(Dog("Bow"), Dog("woof"))
  printAnimalNames(cats)
  printAnimalNames(dogs)

}


