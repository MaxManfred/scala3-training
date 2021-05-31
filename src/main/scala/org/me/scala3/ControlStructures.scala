package org.me.scala3

import java.io.IOException

object ControlStructures {

  def main(args: Array[String]): Unit = {
    ifElse()
    forLoop()
    forExpression()
    matchExpression1()
    matchExpression2()
    matchExpression3()
    tryCatchFinally()
    whileLoop()
  }

  def ifElse(): Unit = {
    val x = 1808

    val y = if x < 0 then
      println("Negative")
    else if x == 0 then
      println("Zero")
    else
      println("Positive")

    println(s"y is $y")
  }

  def forLoop(): Unit = {
    val ints = List(1, 2, 3, 4, 5)
    for
      i <- ints
      if i > 2
    do
      println(i)
  }

  def forExpression(): Unit = {
    val fruits = List("apple", "banana", "lime", "orange")

    val fruitLengths = for
      f <- fruits
      if f.length > 4
    yield
      f.length

    println(fruitLengths)
  }

  def matchExpression1(): Unit = {
    val i = 1

    val result = i match
      case 1 => "one"
      case 2 => "two"
      case _ => "other"

    println(result)
  }

  def matchExpression2(): Unit = {
    val p = Person("Fred", "Flintstone")

    p match
      case Person(firstName, lastName) if firstName == "Fred" =>
        println(s"$firstName says, Yubba dubba doo")

      case Person(firstName, lastName) if firstName == "Bam Bam" =>
        println(s"$firstName says, Bam bam!")

      case _ => println("Watch the Flintstones!")

  }

  def matchExpression3(): Unit = {
    val p = Person("Fred", "Flintstone")

    println(s"1 is of type ${getClassAsString(1)}")                               // Int
    println(s"\"hello\" is of type ${getClassAsString("hello")}")                 // 'hello' is a String
    println(s"${List(1, 2, 3)} is of type ${getClassAsString(List(1, 2, 3))}")    // List
    println(s"$p is of type ${getClassAsString(p)}")                              // Unknown
  }

  def tryCatchFinally(): Unit = {
    val text = "Lorem ipsum..."

    try
      writeTextToFile(text)
    catch
      case ioe: IOException => println("Got an IOException.")
      case nfe: NumberFormatException => println("Got a NumberFormatException.")
    finally
      println("Clean up your resources here.")
  }

  def whileLoop(): Unit = {
    var x = 1

//    indentation is crucial here: it's similar to Python
    while
      x < 3
    do
      println(x)
      x += 1
  }

//  UTILITIES

//  getClassAsString is a method that takes a single argument of any type.
  def getClassAsString(x: Any): String =
    x match
      case s: String => "String"
      case i: Int => "Int"
      case d: Double => "Double"
      case l: List[_] => "List"
      case _ => "Unknown"

  def writeTextToFile(value: String): Unit =
    throw IOException("Fake exception")

}

case class Person(firstName: String, lastName: String) {
}
