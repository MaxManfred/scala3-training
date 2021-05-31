package org.me.scala3.collection

@main
def runLists(): Unit =
  creatingLists()
  listMethods()


def creatingLists(): Unit =
  val a = List(1, 2, 3)                       // a: List[Int] = List(1, 2, 3)

//  range methods
  val b = (1 to 5).toList                     // b: List[Int] = List(1, 2, 3, 4, 5)
  val c = (1 to 10 by 2).toList               // c: List[Int] = List(1, 3, 5, 7, 9)
  val e = (1 until 5).toList                  // e: List[Int] = List(1, 2, 3, 4)
  val f = List.range(1, 5)                    // f: List[Int] = List(1, 2, 3, 4)
  val g = List.range(1, 10, 3)                // g: List[Int] = List(1, 4, 7)

def listMethods(): Unit =
//  a sample list
  val a = List(10, 20, 30, 40, 10)            // List(10, 20, 30, 40, 10)

  a.drop(2)                                   // List(30, 40, 10)
  a.dropWhile(_ < 25)                         // List(30, 40, 10)
  a.filter(_ < 25)                            // List(10, 20, 10)
  a.slice(2, 4)                               // List(30, 40)
  a.tail                                      // List(20, 30, 40, 10)
  a.take(3)                                   // List(10, 20, 30)
  a.takeWhile(_ < 30)                         // List(10, 20)

//  flatten
  val b = List(List(1,2), List(3,4))
  b.flatten                                   // List(1, 2, 3, 4)

// map, flatMap
  val nums = List("one", "two")
  nums.map(_.toUpperCase)                     // List("ONE", "TWO")
  nums.flatMap(_.toUpperCase)                 // List('O', 'N', 'E', 'T', 'W', 'O')

//  fold and reduce
  val firstTen = (1 to 10).toList             // List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  firstTen.reduce(_ + _)                      // 55
  firstTen.reduceLeft(_ + _)                  // 55
  firstTen.fold(100)(_ + _)                   // 155 (100 is a “seed” value)
  firstTen.foldLeft(100)(_ + _)               // 155
