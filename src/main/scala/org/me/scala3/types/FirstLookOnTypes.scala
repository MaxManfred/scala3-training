package org.me.scala3.types

@main
def firstLookOnTypes(): Unit =
//  Here’s an example that demonstrates that strings, integers, characters, boolean values, and functions are all
//  instances of Any and can be treated just like every other object:
  val list: List[Any] = List(
    "a string",
    732,  // an integer
    'c',  // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )
  list.foreach(element => println(element))