package exercises

object OOBasicExercises extends App {

  val writer = new Writer("Venkat", "Venkataraman", 1978)
  writer.fullName()
  val novel = new Novel("Blaze of Fire", 2018, writer)
  println("Author's age is " + novel.authorAge())
  val nNovel = novel.copy(2019)
  println("New year of release is " +  nNovel.year)


  val counter = new Counter(5)
  println(counter.currentCount())
  println(counter.increment())
  println(counter.currentCount())
  println(counter.decrement())
  println(counter.currentCount())

  //val recCounter = new recCounter() // default value of 0 as indicated in the constructor
  val recCounter = new recCounter(5)
  recCounter.increment().print
  recCounter.decrement().print
  recCounter.increment(10).print
}

class recCounter(val n : Int = 0) {
  //Adding immutability by returning a new counter instead of incrementing vals in the same counter
  def increment(): recCounter =  { // returns a counter
    println("incrementing")
    new recCounter (n + 1)
  }
  def decrement(): recCounter = { // returns a counter
    new recCounter (n - 1)
  }

  def increment(count : Int ): recCounter = { // use recursion here
    if(count <= 0) this // if incrementing by nothing, just return the current instance
    else {
      increment().increment(count-1)// calling increment() returns a recCounter, and then we do a recCounter(n-1)
      // in order to recursively do this
    }
  }

  def print = println(n)
}


class Writer (firstName : String, lastName:String, val yearofBirth : Int){ // by making in val yearOfBirth, no need for next line
  //val DOB = yearofBirth // because we declared val for yearOfBirth, this is not needed.
  def fullName(): Unit ={
    println(s"${this.firstName}" + " " + s"${this.lastName}")
    println(firstName + " " + lastName) // Both have the same effect
  }
}

class Novel (name : String, yearOfRelease : Int, author : Writer) {

  val year = yearOfRelease

  def authorAge(): Int = {
    //yearOfRelease - author.DOB
    yearOfRelease - author.yearofBirth
  }

  def copy(newYearOfRelease : Int) : Novel = {
    new Novel(name, newYearOfRelease, author)
  }


  /*def copy(newYearOfRelease : Int, bookName : String, writer: Writer ): Novel ={

    new Novel(bookName, newYearOfRelease, writer )
  }*/
}

class Counter(val n : Int) {
  println("input to the countet is " + n)
   var currCount = n

    def currentCount(): Int = {
      currCount
    }

    def increment(): Int =  {
      currCount = currCount + 1

      currCount
    }

  def decrement(): Int = {
    currCount = currCount - 1
    currCount
  }




    }




