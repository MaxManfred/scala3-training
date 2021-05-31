package org.me.scala3

object FirstClassFunctions {

  def main(args: Array[String]): Unit = {
    val a1 = List(1, 2, 3).map(i => i * 2) // List(2,4,6)
    println(a1)

    val b1 = List(1, 2, 3).map(_ * 2) // List(2,4,6)
    println(b1)

    def double(i: Int): Int = i * 2

    val a2 = List(1, 2, 3).map(i => double(i)) // List(2,4,6)
    println(a2)

    val b2 = List(1, 2, 3).map(double) // List(2,4,6)
    println(b2)

    //    a sample list
    val nums = (1 to 10).toList // List(1,2,3,4,5,6,7,8,9,10)

    //    methods can be chained together as needed
    val x = nums
      .filter(_ > 3)
      .filter(_ < 7)
      .map(_ * 10)

    println(x)
  }
}
