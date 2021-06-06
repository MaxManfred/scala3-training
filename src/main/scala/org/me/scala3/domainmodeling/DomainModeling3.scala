package org.me.scala3.domainmodeling

import scala.math

object DomainModeling3 {

  def main(args: Array[String]): Unit = {
    objects1()
    objects2()
    objects3()
    objects4()
    companionObjects1()
    companionObjects2()
  }

  def objects1(): Unit =
    StringUtils.truncate("Chuck Bartowski", 5) // "Chuck"

  def objects2(): Unit =
    import StringUtils.*

    truncate("Chuck Bartowski", 5) // "Chuck"
    containsWhitespace("Sarah Walker") // true
    isNullOrEmpty("John Casey") // false

  def objects3(): Unit =
    import StringUtils.{containsWhitespace, truncate}

    truncate("Charles Carmichael", 7) // "Charles"
    containsWhitespace("Captain Awesome") // true
  //    isNullOrEmpty("Morgan Grimes")          // Not found: isNullOrEmpty (error)

  def objects4(): Unit =
    println(MathConstants.PI) // 3.14159

  def companionObjects1(): Unit =
    val circle1 = Circle(5.0)
    println(circle1.area)

  def companionObjects2(): Unit =
    val joe = Individual("Joe")
    println(joe)

    val fred = Individual("Fred", 29)
    println(fred)
}

object StringUtils:

  def truncate(s: String, length: Int): String =
    s.take(length)

  def containsWhitespace(s: String): Boolean =
    s.matches(".*\\s.*")

  def isNullOrEmpty(s: String): Boolean =
    if s == null || s.trim.equals("") then
      true
    else
      false

object MathConstants:
  val PI = 3.14159

  val E = 2.71828

case class Circle(radius: Double):

  def area: Double =
    Circle.calculateArea(radius)

case object Circle:

  private def calculateArea(radius: Double): Double = {
    import MathConstants.*
    import Math.pow

    PI * pow(radius, 2.0)
  }

case class Individual(var name: String = "", var age: Int = 0):

  override def toString =
    s"$name is $age years old"

case object Individual:

  //  a one-arg factory method
  def apply(name: String): Individual =
    var i = new Individual(name = name)
    i

  //  a two-arg factory method
  def apply(name: String, age: Int): Individual =
    var i = new Individual
    i.name = name
    i.age = age
    i


