package lectures.part3fp

object TuplesAndMaps extends App {
  //tuples are finite ordered lists
  val aTuple = Tuple2 (2, "Hello, Scala") // Tuple2[Int, String]
  println(aTuple._2) //"Hello, Scala"
  println(aTuple.copy(_2 = "goodbye java")) // replace hello scala with this
  println(aTuple.swap) // ("Hello,Scala" , 2)

  //Maps - Immutable
  val phoneBook  = Map (("VV", 789), ("Jim", 123))// can also be written as Jim -> 123
  val sPhoneBook = Map ("VV" -> "M", "GK" -> "F")
  val aphoneBook  = Map (("VV", 789), "Jim" -> 123).withDefaultValue(-1) // both are same, but withDefaultValue returns a default value when key is not present

  println(aphoneBook)
  println(aphoneBook("VV"))

  //functionals on maps
  //map, flatmap and filter
  //map takes a pairing
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2)) // this will make keys lower case
  println(sPhoneBook.map(pair => pair._1.toLowerCase() -> pair._2.toLowerCase()))
  //filterkeys
  println(sPhoneBook.filterKeys(p => p.startsWith("G")))

  //mapValues
  println(aphoneBook.mapValues( x => x * 10))

  //conversions
  println(aphoneBook.toList)
  println(List(("IV", 888)).toMap)

  /*
  Exercise - Social network that does a bunch of stuff with a Person string
  add - add a person to the network
   */

  //Add a person into the network
  def add(network : Map[String, Set[String]], person : String) : Map[String, Set[String]] = {
    network + (person -> Set())
  }

  //Add A & B as friends to one another into the network (this network is the entire universe, not an individual's network)
  def friend(network : Map[String, Set[String]], personA : String, personB : String): Map[String, List[String]] = {
    val friendsA : Set[String] = network(personA) // returns a Set
    val friendsB : Set[String] = network(personB)
    val addFriendIntoA : Set[String] = friendsA + personB // Add personB into Set of A
    val addFriendIntoB : Set[String] = friendsB + personA // Add personA into Set of B
    val tempNetwork : Map[String, Set[String]] = network + (personA -> addFriendIntoA)
    val finalNetwork = tempNetwork + (personB -> addFriendIntoB)
    finalNetwork
  }

  def unFriend(network : Map[String, Set[String]], personA : String, personB : String): Map[String, List[String]] = {
    val friendsA : Set[String] = network(personA) // returns a Set
    val friendsB : Set[String] = network(personB)
    val removeFriendFromA : Set[String] = friendsA - personB // Add personB into Set of A
    val removeFriendFromB : Set[String] = friendsB - personA // Add personA into Set of B
    val tempNetwork : Map[String, Set[String]] = network + (personA -> removeFriendFromA)
    val finalNetwork : Map[String, Set[String]] = (tempNetwork + (personB -> removeFriendFromB))
    finalNetwork
  }

  def remove(network : Map[String, Set[String]], personToBeRemoved : String) : Map[String, Set[String]] = {
    /*
    First get the list of all friends for that person, and for each person unfriend them, and then remove from network
     */
    val setOfFriends : Set[String] = network(personToBeRemoved)
    setOfFriends.foreach { friend =>
      unFriend(network, friend, personToBeRemoved)
    }
    network.-(personToBeRemoved)
  }

  val network = Map(("Jim" -> Set("VV", "Brian", "Corey")), "VV" -> Set("Jim", "John"))
  add(network, "GK")
  //remove(network, "VV")
  println(network)



}
