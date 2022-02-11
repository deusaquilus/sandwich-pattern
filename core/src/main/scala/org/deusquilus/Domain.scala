package org.deusaquilus

object Domain {
  case class Person(id: Int, name: String, age: Int)
  case class Address(fk: Int, street: String, zip: Int)
}