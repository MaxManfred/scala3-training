package org.me.scala3.oop

trait AddService:

  def add(a: Int, b: Int) = a + b

trait MultiplyService:

  def multiply(a: Int, b: Int) = a * b

// implement those traits as a concrete object
object MathService extends AddService, MultiplyService

@main
def runModulesFromTraits(): Unit =

  // use the object
  import MathService.*

  println(add(1, 1))        // 2
  println(multiply(2, 2))   // 4