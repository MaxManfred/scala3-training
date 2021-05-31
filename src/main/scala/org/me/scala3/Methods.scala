package org.me.scala3

import java.io.{PrintWriter, StringWriter}

object Methods {

  def main(args: Array[String]): Unit = {
    methods1()
    methods2()
    methods3()
    methods4()
  }

  def methods1(): Unit =
    val x = sum(1, 2)
    println(x)

    val y = concatenate("foo", "bar")
    println(y)

  def methods2(): Unit =
    println(getStackTraceAsString(new NullPointerException("Dummy exception")))

  def methods3(): Unit =
    makeConnection("https://localhost") // url=http://localhost, timeout=5000
    makeConnection("https://localhost", 2500) // url=http://localhost, timeout=2500
    makeConnection(url = "https://localhost", timeout = 2500)

  def methods4(): Unit =
    println("world".hello) // "Hello, World!"
    println("friend".aloha) // "Aloha, Friend!"

    println("1".makeInt(2)) // Int = 1
    println("10".makeInt(2)) // Int = 2
    println("100".makeInt(2)) // Int = 4

  //  UTILITIES
  def sum(a: Int, b: Int): Int = a + b

  def concatenate(s1: String, s2: String): String = s1 + s2

  def getStackTraceAsString(t: Throwable): String =
    val sw = new StringWriter
    t.printStackTrace(new PrintWriter(sw))
    sw.toString

  def makeConnection(url: String, timeout: Int = 5000): Unit =
    println(s"url = $url, timeout = $timeout")

  extension (s: String)
    def hello: String = s"Hello, ${s.capitalize}!"

    def aloha: String = s"Aloha, ${s.capitalize}!"

    def makeInt(radix: Int): Int = Integer.parseInt(s, radix)
}
