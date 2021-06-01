package org.me.scala3.controlstructures

import org.me.scala3.controlstructures.Person

import java.io.IOException
import scala.annotation.switch


object ControlStructures {

  def main(args: Array[String]): Unit = {
    ifElse()
    forLoop()
    forExpression()
    tryCatchFinally()
    whileLoop()
    matchExpression1()
    matchExpression2()
    matchExpression3()
    matchExpression4(3)
    matchExpressison5(2)
    matchExpression6(7)
    matchExpression7()
    matchExpression8()
    matchExpression9()
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
      case _ =>
        println("Watch the Flintstones!")
  }

  def matchExpression3(): Unit = {
    val p = Person("Fred", "Flintstone")

    println(s"1 is of type ${getClassAsString(1)}")                               // Int
    println(s"\"hello\" is of type ${getClassAsString("hello")}")                 // 'hello' is a String
    println(s"${List(1, 2, 3)} is of type ${getClassAsString(List(1, 2, 3))}")    // List
    println(s"$p is of type ${getClassAsString(p)}")                              // Unknown
  }

  def matchExpression4(@switch i: Int): Unit =
//    i is an integer
    val day = i match
      case 0 => "Sunday"
      case 1 => "Monday"
      case 2 => "Tuesday"
      case 3 => "Wednesday"
      case 4 => "Thursday"
      case 5 => "Friday"
      case 6 => "Saturday"
      case what => s"$what is an invalid day"   // the default, catch-all

    println(s"Day $i is $day")

  def matchExpressison5(@switch i: Int): Unit =
    val evenOrOdd = i match
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
      case _ => println("some other number")

  def matchExpression6(@switch i: Int): Unit =
    i match
      case a if 0 to 9 contains a => println(s"0-9 range: $a")
      case b if 10 to 19 contains b => println(s"10-19 range: $b")
      case c if 20 to 29 contains c => println(s"20-29 range: $c")
      case _ => println("Hmmm...")

  def matchExpression7(): Unit =
    case class Person(name: String)

    def speak(p: Person) = p match
      case Person(name) if name == "Fred" => println(s"$name says, Yubba dubba doo")
      case Person(name) if name == "Bam Bam" => println(s"$name says, Bam bam!")
      case _ => println("Watch the Flintstones!")

    speak(Person("Fred"))      // "Fred says, Yubba dubba doo"
    speak(Person("Bam Bam"))   // "Bam Bam says, Bam bam!"

  def matchExpression8(): Unit =
    def isTruthy(a: Matchable) = a match
      case 0 | "" => false
      case _ => true

    println(isTruthy(0))      // false
    println(isTruthy(""))     // false
    println(isTruthy(1))      // true
    println(isTruthy(" "))    // true
    println(isTruthy(2F))     // true

  def matchExpression9(): Unit =
    case class Dog(name: String)

    def pattern(x: Matchable): String = x match
//      constant patterns
      case 0 => "zero"
      case true => "true"
      case "hello" => "you said 'hello'"
      case Nil => "an empty List"

//      sequence patterns
      case List(0, _, _) => "a 3-element list with 0 as the first element"
      case List(1, _*) => "list, starts with 1, has any number of elements"
      case Vector(1, _*) => "vector, starts w/ 1, has any number of elements"

//      tuple patterns
      case (a, b) => s"got $a and $b"
      case (a, b, c) => s"got $a, $b, and $c"

//      constructor patterns
      case Person(first, "Alexander") => s"Alexander, first name = $first"
      case Dog("Zeus") => "found a dog named Zeus"

//      type test patterns
      case s: String => s"got a string: $s"
      case i: Int => s"got an int: $i"
      case f: Float => s"got a float: $f"
      case a: Array[Int] => s"array of int: ${a.mkString(",")}"
      case as: Array[String] => s"string array: ${as.mkString(",")}"
      case d: Dog => s"dog: ${d.name}"
      case list: List[_] => s"got a List: $list"
      case m: Map[_, _] => m.toString

//      the default wildcard pattern
      case _ => "Unknown"

    println(pattern(Nil))
    println(pattern(List(0, 1, 2)))
    println(pattern((1, 2)))
    println(pattern(Dog("Zeus")))
    println( pattern(2.0f))

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
