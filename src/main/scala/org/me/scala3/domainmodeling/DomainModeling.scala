package org.me.scala3.domainmodeling

object DomainModeling {

  def main(args: Array[String]): Unit = {
    oopModeling()
    fpModeling1()
    fpModeling2()
  }

  def oopModeling(): Unit = {
    val d = Dog("Rover")
    println(d.speak()) // prints "Woof!"

    val c = Cat("Morris")
    println(c.speak()) // "Meow"
    c.startRunning() // "Yeah ... I don’t run"
    c.stopRunning()
  }

  def fpModeling1(): Unit = {
    val currentCrustSize = CrustSize.Small

//    enums in a match expression
    currentCrustSize match
      case CrustSize.Small => println("Small crust size")
      case CrustSize.Medium => println("Medium crust size")
      case CrustSize.Large => println("Large crust size")

//    enums in an if statement
    if currentCrustSize == CrustSize.Small then println("Small crust size")
  }

  def fpModeling2(): Unit = {
//    define a case class
    case class Person(name: String, vocation: String)

//    create an instance of the case class
    val p = Person("Reginald Kenneth Dwight", "Singer")

//    a good default toString method
    println(p)                // org.me.scala3.controlstructures.Person = org.me.scala3.controlstructures.Person(Reginald Kenneth Dwight,Singer)

//    can access its fields, which are immutable
    println(p.name)           // "Reginald Kenneth Dwight"
//    p.name = "Joe"   // error: can’t reassign a val field

    // when you need to make a change, use the copy method to “update as you copy”
    val p2 = p.copy(name = "Elton John")
    println(p2)               // org.me.scala3.controlstructures.Person = org.me.scala3.controlstructures.Person(Elton John,Singer)
  }
}

class Dog(name: String) extends Speaker, TailWagger, Runner {

  def speak(): String = "Woof!"
}

class Cat(name: String) extends Speaker, TailWagger, Runner {

  def speak(): String = "Meow"

  override def startRunning(): Unit =
    println("Yeah ... I don’t run")

  override def stopRunning(): Unit =
    println("No need to stop")
}

/**
 * TODO
 */
trait Speaker:
  /**
   * TODO
   *
   * @return TODO
   */
  def speak(): String // has no body, so it’s abstract

/**
 * TODO
 */
trait TailWagger:

  /**
   * TODO
   */
  def startTail(): Unit = println("tail is wagging")

  /**
   * TODO
   */
  def stopTail(): Unit = println("tail is stopped")

/**
 * TODO
 */
trait Runner:

  /**
   * TODO
   */
  def startRunning(): Unit = println("I’m running")

  /**
   * TODO
   */
  def stopRunning(): Unit = println("Stopped running")

enum CrustSize:
  case Small, Medium, Large

enum CrustType:
  case Thin, Thick, Regular

enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions
