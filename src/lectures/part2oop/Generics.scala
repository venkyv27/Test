package lectures.part2oop

object Generics extends App {
  class MyList[+A] {
    // use the type A inside class defn
    //def add(element : A) : MyList[A] = ??? // empty implementation
    def add[B >: A] (element : B) : MyList[B] = ??? // This means if a list expects A, but we send in B which is "eventually"
    //a superclass of A, then it'll return a list of B.
    /*
     A = Cat
     B = Dog = Animal
     Returned list of animals instead of cat now.
     */

  }

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

    //companion object
  object MyList {
      def empty [A] : MyList[A] = ??? // a generic method that returns MyList
    }

  val emptyListInt = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //There are different options with a concept called variance
  //1. Yes. List[Cat] extends List[Animal] = this is called COVARIANCE
  class CovariantList[+A]
  val animal : Animal = new Cat
  val animalList : CovariantList[Animal] = new CovariantList[Cat]
  //now can we do animalList.add[Dog], this will the list of cats with Dogs.

  //2. No. INVARIANCE

  class InvariantList[A] // there is no + here for invariance
  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]// You cannot add [Cat] here because it
  //expect only type Animal


  //Contra variance
  //ContraVariance[-A] here is -ve sign here
  class Trainer[-A]
  val trainer : Trainer[Cat] = new Trainer[Animal] // A trainer of animals can train a cat too.


  //Bounded Types
  /*class Cage[A >: Animal] (animal : A)
  val cage = new Cage[new Cat] // This is allowed

*/

}
