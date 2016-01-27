package fixture

import models._
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.driver.JdbcProfile
import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite

trait PlaySpec extends WordSpec
  with OneAppPerSuite
  with SequentialNestedSuiteExecution
  with Matchers
  with OptionValues
  with HasDatabaseConfig[JdbcProfile]
  with AddressDatabaseModule {

  protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  import driver.api._


}
