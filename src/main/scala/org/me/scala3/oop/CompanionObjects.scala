package org.me.scala3.oop

import scala.math.*;

class Circle(radius: Double):

  def area(): Double = {
    import Circle.*

    calculateArea(radius)
  }


object Circle:

  private def calculateArea(radius: Double): Double =
    Pi * pow(radius, 2.0d)

@main
def run(): Unit =
  val circle1 = Circle(5.0d)
  println(circle1.area())