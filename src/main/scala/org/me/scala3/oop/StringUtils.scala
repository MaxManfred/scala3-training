package org.me.scala3.oop

object StringUtils {

  def isNullOrEmpty(s: String): Boolean =
    if (s == null || s.trim.equals(""))
      true
    else
      false

  def leftTrim(s: String): String =
    s.replaceAll("^\\s+", "")

  def rightTrim(s: String): String =
    s.replaceAll("\\s+$", "")
}
