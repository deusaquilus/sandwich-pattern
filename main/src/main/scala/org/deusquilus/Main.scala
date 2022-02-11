package org.deusaquilus

import org.deusaquilus.DatabaseService

object Main {
  def main(args: Array[String]) =
    println(DatabaseService.peopleAddresses.string)
}