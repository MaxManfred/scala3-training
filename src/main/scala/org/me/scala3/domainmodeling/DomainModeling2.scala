package org.me.scala3.domainmodeling

import java.time.*

object DomainModeling2 {

  def main(args: Array[String]): Unit = {
    classes1()
    classes2()
    classes3()
    classes4()
  }

  def classes1(): Unit =
    val p = Person("Robert Allen Zimmerman", "Harmonica Player")

    println(p.name)       // "Robert Allen Zimmerman"
    println(p.vocation)   // "Harmonica Player"

//    all of these parameters were created as var fields, so you can also mutate them:

    p.name = "Bob Dylan"
    p.vocation = "Musician"

    println(p.name)       // "Bob Dylan"
    println(p.vocation)   // "Musician"

  def classes2(): Unit =
    class Person(var firstName: String, var lastName: String):
      println("initialization begins")
      val fullName = firstName + " " + lastName

//      a class method
      def printFullName: Unit =
//        access the `fullName` field, which is created above
        println(fullName)

      printFullName

      println("initialization ends")

    Person("Max", "Manfred")

  def classes3(): Unit =
//    default parameter values and named parameters
    println(Socket())                   // timeout: 5000, linger: 5000
    println(Socket(2_500))              // timeout: 2500, linger: 5000
    println(Socket(10_000, 10_000))     // timeout: 10000, linger: 10000
    println(Socket(timeout = 10_000))   // timeout: 10000, linger: 5000
    println(Socket(linger = 10_000))    // timeout: 5000, linger: 10000

//    option 1
    val s1 = Socket(10_000, 10_000)

//    option 2
    val s2 = Socket(linger = 10_000, timeout = 10_000)

  def classes4(): Unit =
//    multiple constructors
    val s1 = Student("Mary", "123")
    println(s1)

    val s2 = Student("Mary", "123", LocalDate.now)
    println(s2)

    val s3 = Student("Mary", "123", 456)
    println(s3)
}

class Person(var name: String, var vocation: String)

class Book(var title: String, var author: String, var year: Int)

class Movie(var name: String, var director: String, var year: Int)

class Socket(val timeout: Int = 5_000, val linger: Int = 5_000):

  override def toString =
    s"timeout: $timeout, linger: $linger"



// [1] the primary constructor
class Student(var name: String, var govtId: String):

  private var _applicationDate: Option[LocalDate] = None

  private var _studentId: Int = 0

//  [2] a constructor for when the student has completed their application
  def this(name: String, govtId: String, applicationDate: LocalDate) =
    this(name, govtId)
    _applicationDate = Some(applicationDate)

//  [3] a constructor for when the student is approved and now has a student id
  def this(name: String, govtId: String, studentId: Int) =
    this(name, govtId)
    _studentId = studentId

  override def toString: String =
    s"Application date: ${_applicationDate.getOrElse("N/A")}, Student ID: $_studentId"