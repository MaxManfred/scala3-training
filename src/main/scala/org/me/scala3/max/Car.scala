package org.me.scala3.max

import org.me.scala3.max.{Brand, Segment}

case class Car(brand: Brand, model: String, segment: Segment) extends Gear:

  override def up(): Unit =
    println("UP SHIFT")

  override def down(): Unit =
    println("DOWN SHIFT")
