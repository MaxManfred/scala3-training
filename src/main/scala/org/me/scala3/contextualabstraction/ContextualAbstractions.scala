package org.me.scala3.contextualabstraction

@main
def runContextualAbtractions(): Unit =
  sortAddresses()

def sortAddresses(): Unit = {
  val addresses: List[Address] = List(
    Address("Via Peveragno 3", "Roma"),
    Address("Via Leonardo da Vinci 7", "Scafati"),
  )

//  Contextual Abstractions are used to avoid repetition of code

//    The sortBy method takes a function that returns, for every address, the value to compare it with the other addresses.
//    In this case, we pass a function that returns a pair containing the city name and the street name.
//    Note that we only indicate what to compare, but not how to perform the comparison.
  val defaultSortedAddresses: List[Address] = addresses.sortBy(address => address.city)
  println(defaultSortedAddresses)

//  Actually, the sortBy method takes a second parameter—a context parameter—that is inferred by the compiler.
//  It does not appear in the above example because it is supplied by the compiler.
//  This second parameter implements the how to compare.
//  It is convenient to omit it because we know Strings are generally compared using the lexicographic order.
  val customSortedAddresses: List[Address] = addresses.sortBy(address => address.city)(Ordering.String.reverse)
  println(customSortedAddresses)
}

case class Address(street: String, city: String)


