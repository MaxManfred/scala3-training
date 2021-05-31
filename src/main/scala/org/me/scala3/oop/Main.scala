package org.me.scala3.oop

import org.me.scala3.oop.StringUtils.isNullOrEmpty

@main
def main(): Unit =
  val x = isNullOrEmpty("")    // true
  println(x)

  val y = isNullOrEmpty("a")   // false
  println(y)

