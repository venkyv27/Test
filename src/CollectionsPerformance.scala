import scala.util.Random

object CollectionsPerformance extends App{

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection : Seq[Int]) : Double = { // take in a param called collection (not scala collections) which is a Seq[Int]
    val r = new Random
    //using for comprehension to iterate
    val times = for {
      it <- 1 to maxRuns

    } yield {
      val currentTime = System.nanoTime()
      //do an operation - replace a certain randomly picked index in the Seq with a random number
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum / maxRuns // get the average across all runs


  }
  val numbersList = (1 to maxCapacity).toList // pass in a list
  val numbersVector = (1 to maxCapacity).toVector // and pass in a vector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}
