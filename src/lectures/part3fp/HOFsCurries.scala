package lectures.part3fp

object HOFsCurries extends App {
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  /*
  For the above line, the return type is a function which takes in an Int and returns an Int (on the right most side before = ???)
  The superFunction itself takes 2 params, one Int, and another function which takes in a String, and another function which takes an Int and
  returns a Boolean, and the return type of this is an int. This is a higher order function.
   */

  /*function that applies a function n times over a value x
  ntimes(f, n, x)
  ntimes(f, 3, x) = f(f(f(x)))
   */

  //nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f : Int => Int, n : Int, x : Int): Int ={
    if(n <= 0) x
    else nTimes(f, n-1, f(x) )
  }
  def plusOne : Int => Int = x => x+ 1
  //print(nTimes(plusOne, 4, 1))

  def nTimesBetter(f : Int=>Int, n : Int) : (Int => Int) = {
    if (n<=0) (x : Int) => x
    else (x:Int) => nTimesBetter(f, n-1) (f(x))
  }
  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  val superAdder: Int => Int => Int = (x : Int) => (y : Int) => x+ y
  /*
  superAdder is implemented with anonymous functions. It defines a function which takes in an int (x : Int) and returns another
  function, which in turn takes in an int (y:Int), and returns the sum of x + y
   */
  val add3 = superAdder(3) // x is 3, y is still not passed in here and output is 3+ y
  println(superAdder(3) (10)) // x =3, y= 10

  //function with multiple param lists
  def curriedFormater(c:String) (x: Double) = c.format(x)



}
