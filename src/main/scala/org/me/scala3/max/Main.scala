package org.me.scala3.max

import org.me.scala3.max.{Brand, Car}

@main def main: Unit =
  val toyotaYaris = Car(brand = Brand.TOYOTA, model = "Yaris Diesel", segment = Segment.B)
  println(s"My car is a $toyotaYaris")

  toyotaYaris.up()
  toyotaYaris.up()

  toyotaYaris.down()

