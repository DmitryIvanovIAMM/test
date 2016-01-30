package fixture

import models._
import play.api.Play
import play.api.db.DBApi
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.FakeApplication
import slick.driver.JdbcProfile
import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite

//import DefaultDBApi._

trait PlaySpec extends WordSpec
  with OneAppPerSuite
  with SequentialNestedSuiteExecution
  with BeforeAndAfterAll
  with Matchers
  with OptionValues
  with HasDatabaseConfig[JdbcProfile]
  with AddressDatabaseModule {

  //protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](FakeApplication())
  protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  /*lazy val appBuilder = new GuiceApplicationBuilder()

  lazy val injector = appBuilder.injector()

  lazy val databaseApi = injector.instanceOf[DBApi] //here is the important line*/
  //import driver.api._
  //defaultConnectionPool: ConnectionPool = new HikariCPConnectionPool(environment)
  /*val conf = Map(
    "slick.dbs.default.driver" -> "slick.driver.H2Driver$",
    "slick.dbs.default.db.driver" -> "org.h2.Driver",
    "slick.dbs.default.db.url" -> "jdbc:h2:mem:education-link;MODE=PostgreSQL;DB_CLOSE_ON_EXIT=FALSE",
    "slick.dbs.default.db.user" -> "sa",
    "slick.dbs.default.db.password" -> "",
    "slick.dbs.default.db.logStatements" -> "true",
    "slick.dbs.default.db.connectionTimeout" -> "30000",
    "slick.dbs.default.db.maxConnectionsPerPartition" -> "100",
    "slick.dbs.default.db.minConnectionsPerPartition" -> "10",
    "slick.dbs.default.db.acquireIncrement" -> "10"
  )

  implicit lazy val fakeApp: FakeApplication = new FakeApplication(additionalConfiguration = conf)

  Play.start(fakeApp) /// <--- This creates the application*/



}
