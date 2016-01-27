package data

import models._
import util.Logging
import scala.concurrent.Future
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import org.joda.time.DateTime
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.driver.JdbcProfile
import scala.concurrent.Await
import scala.concurrent.duration.Duration

class TestDataLoader extends HasDatabaseConfig[JdbcProfile] with Logging
  with AddressDatabaseModule {

  protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  import driver.api._

  lazy val today = DateTime.now()

  lazy val insertAddresses =
    Addresses ++= Seq(
      Address(None, "111 Philips Blvd", "Princeton", "NY", "08540"),
      Address(None, "NY City", "Philips", "NY", "08540"),
      Address(None, "Vashington DC", "Princeton", "NY", "08540"),
      Address(None, "Vasya Family Address1", "Los Angeles 1", "NY", "83001"),
      Address(None, "Vasya Family Address2", "Los Angeles 2", "WA", "83002"),
      Address(None, "Vasya Family Address3", "Los Angeles 3", "IL", "83003")
    )

  def insertTestData(): Unit = {
    info("waiting test data to be inserted")
    Await.result( db.run( insertAddresses ), 100.second )
    info("done test data dealing")
    ()
  }

}
