package dao

import models._
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.driver.JdbcProfile
import util.Logging
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object AddressDao extends Logging
  with HasDatabaseConfig[JdbcProfile]
  with AddressDatabaseModule {

  protected val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  import driver.api._

  def queryById(addressId: Int): Future[Option[Address]] = db.run {
    Addresses.filter(_.id === addressId)
      .result
      .headOption
  }

}