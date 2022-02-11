package org.deusaquilus

import io.getquill._

object DatabaseService {
  import Domain._

  val ctx = new SqlMirrorContext(PostgresDialect, Literal)
  import ctx._

  inline def q = quote {
    for {
      p <- query[Person]
      a <- query[Address].join(a => a.fk == p.id)
    } yield (p, a)
  }

  def peopleAddresses = run(q)
}
