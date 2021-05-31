package org.me.scala3.collection

@main
def runTuples(): Unit =
  creatingTuples()

def creatingTuples(): Unit =
  case class Person(name: String)

  val t = (11, "eleven", Person("Eleven"))

  println(t._1)   // 11
  println(t._2)   // "eleven"
  println(t._3)   // Person("Eleven")

  val (num, str, person) = t

  println(num)      // 11
  println(str)      // "eleven"
  println(person)   // Person("Eleven")