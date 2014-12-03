package chapter6

object Chapter_6_1 {
  def main(args: Array[String]) = {

    var rng = SimpleRNG(42)
    val (i, rg1) = nonNegativeInt(rng)
    println(i)
    val (i2, rg2) = nonNegativeInt(rg1)
    println(i2)
    val (i3, rg3) = double(rg2)
    println(i3)
  }

  /*
  Exercise 6.1
  Write a function that uses RNG.nextInt to generate a random integer between 0 and Int.maxValue (inclusive).
  Make sure to handle the corner case when nextInt returns Int.MinValue, which doesn’t have a non-negative counterpart.
 */
  def nonNegativeInt(rng: RNG): (Int, RNG)  = {
    val (i, r) = rng.nextInt
    if (i.abs <= Int.MaxValue) (i.abs, r) else nonNegativeInt(r)
  }

  /*
  Exercise 6.2
  Write a function to generate a Double between 0 and 1, not including 1. Note: You can use Int.MaxValue to obtain
  the maximum positive integer value, and you can use x.toDouble to convert an x: Int to a Double.
   */
  def double(rng: RNG): (Double, RNG) = {
    val (i, r) = rng.nextInt
    val dbl = (i.toDouble/Int.MaxValue).abs
    if(dbl < 1.0) (dbl, r) else double(r)
  }

  /*
  Exercise 6.3
  Write functions to generate an (Int, Double) pair, a (Double, Int) pair, and a (Double, Double, Double) 3-tuple.
  You should be able to reuse the functions you’ve already written.
  */
}
