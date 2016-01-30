package dao

import play.api.db.slick.HasDatabaseConfig
import play.api.libs.concurrent.Akka

trait SomeCrudBase {
  //implicit lazy val context = Akka.system.dispatchers.lookup("db-context")
}