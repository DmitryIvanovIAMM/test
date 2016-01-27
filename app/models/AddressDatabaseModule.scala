package models

import play.api.db.slick.HasDatabaseConfig
import slick.driver.JdbcProfile

trait AddressDatabaseModule {
  self: HasDatabaseConfig[JdbcProfile] =>

  import driver.api._

  class AddressTable(tag: Tag) extends Table[Address](tag, "ADDRESS") {
    def id = column[Int]("ADDRESS_ID", O.PrimaryKey, O.AutoInc)
    def address1 = column[String]("ADDRESS1")
    def city = column[String]("CITY")
    def state = column[String]("STATE")
    def zip = column[String]("ZIP")

    def * = (id.?, address1, city, state, zip) <> (Address.tupled, Address.unapply)
  }
  lazy val Addresses = TableQuery[AddressTable]

}
